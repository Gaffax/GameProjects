package data;

import static helpers.Artist.beginSession;
import helpers.StateManager;

import org.lwjgl.opengl.Display;

public class Boot {

	public Boot(){

		beginSession();
		
		
		while(!Display.isCloseRequested()){
			
			StateManager.update();
			
			Display.update();
		}
	}
	
	public static void main(String[] args) {

		new Boot();

	}

}
