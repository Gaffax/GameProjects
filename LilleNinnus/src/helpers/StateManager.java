package helpers;

import data.Game;
import data.Introduction;
import data.MainMenu;

public class StateManager {

	public static enum GameState {
		INTRODUCTION, MAINMENU, GAME;
	}
	
	public static GameState gameState = GameState.INTRODUCTION;
	public static Introduction introduction;
	public static MainMenu mainMenu;
	public static Game game;
	
	public static void update() {
		
		switch(gameState){
		case INTRODUCTION:
			if(introduction == null)
				introduction = new Introduction();
			introduction.incrementCounter();
			introduction.update();
			break;
		case MAINMENU:
			if(mainMenu == null)
				mainMenu = new MainMenu();
			mainMenu.update();
			break;
		case GAME:
			if(game == null)
				game = new Game();
			break;
		default:
			break;
		}
	}

	public static GameState getGameState() {
		return gameState;
	}

	
	//I choose a slightly different approach than the tutorial. Works, and is 
	public static void setGameState(GameState gameState) {
		StateManager.gameState = gameState;
	}
	
	
}