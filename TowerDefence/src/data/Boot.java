package data;

import helpers.Clock;
import helpers.StateManager;

import org.lwjgl.opengl.Display;

import static helpers.Artist.*;
import data.Game;

public class Boot {

	public Boot() {

		beginSession();

		// Game game = new Game(map);
		while (!Display.isCloseRequested()) {
			Clock.Update();

			 // game.update();
			StateManager.update();
			
			
			Display.update();
			Display.sync(60);
		}

		Display.destroy();
	}

	public static void main(String[] args) {
		new Boot();

	}

}
