package data;

import static helpers.Artist.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import ui.UI;

public class MainMenu {

	private Texture background;
	private UI menuUI;
	private boolean isLeftMouseButtonDown = false;
	
	public MainMenu() {
		background = QuickLoad("Scene_1_3_beginning");
		menuUI = new UI();
		menuUI.addButton("Play", "playButton", WIDTH/2 - 128, (int) (HEIGHT * 0.45f));
		menuUI.addButton("Editor", "editorButton", WIDTH/2 - 128, (int) (HEIGHT * 0.55f));
		menuUI.addButton("Quit", "quitButton", WIDTH/2 - 128, (int) (HEIGHT * 0.65f));
	}
	
	private void updateButtons(){
		if(Mouse.isButtonDown(0) && !isLeftMouseButtonDown){
			if(menuUI.isButtonClicked("Play"))
				System.out.println("Play button clicked.");
		}
		isLeftMouseButtonDown = Mouse.isButtonDown(0);
	}
	
	public void update() {
		DrawQuadTexture(0, 0, 1280, 960, background);
		menuUI.draw();
		updateButtons();
	}
}
