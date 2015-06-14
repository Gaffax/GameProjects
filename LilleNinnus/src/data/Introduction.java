package data;

import static helpers.Artist.DrawQuadTexture;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.QuickLoad;
import static helpers.Artist.WIDTH;
import helpers.StateManager;
import helpers.StateManager.GameState;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public class Introduction {

	private ArrayList<Texture> introductionList;
	private Texture background;
	private int introductionCounter = 0;
	private boolean isLeftMouseButtonDown = false;

	public Introduction(){
	
		introductionList = new ArrayList<Texture>();
		introductionList.add(QuickLoad("Scene_1_0_beginning"));
		introductionList.add(QuickLoad("Scene_1_1_beginning"));
		
		
		background = introductionList.get(introductionCounter);

		
	}
	
	public void update() {
		
		// DrawQuadTexture(HEIGHT * 0.15f, WIDTH * 0.15f, 1280, 960, background);
		
		// Center image
		DrawQuadTexture(HEIGHT * 0.15f, WIDTH * 0.15f, 1280, 960, background);
	}
	
	public void incrementCounter(){
		if(Mouse.isButtonDown(0) && !isLeftMouseButtonDown){
			if(introductionCounter < introductionList.size() -1){
				introductionCounter++;
				System.out.println("Button " + introductionCounter);
				background = introductionList.get(introductionCounter);			
				
			} else {
				StateManager.setGameState(GameState.MAINMENU);
				
			}
		}
		isLeftMouseButtonDown = Mouse.isButtonDown(0);
	}
}
