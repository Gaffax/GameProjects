package data;

import static helpers.Artist.HEIGHT;
import static helpers.Leveler.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Editor {

	private TileGrid grid;
	private int index;
	private TileType[] types;
	private boolean rightMouseButtonDown = false;
	
	public Editor() {
		grid = loadMap("newMap1");
		// grid = new TileGrid();
		this.index = 0;
		
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
	}

	public void update() {
		grid.Draw();

		// Handle mouse input

		//Paint set current tile type
		if (Mouse.isButtonDown(0)) {
			setTile();
		}

		// One click, one update.
		//Changes the current tile type to be placed.
		if (Mouse.isButtonDown(1) && !rightMouseButtonDown) {
			moveIndex();
		}
		rightMouseButtonDown = Mouse.isButtonDown(1);
		
		
		
		
		// Handle keyboard input
		while (Keyboard.next()) {
			// Gets the right key input. Needs the getEventKeyState to make
			// sure,
			// that the input is passed only once, every time it key is pressed.
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT
					&& Keyboard.getEventKeyState()) {
				moveIndex();
			}
			
			if (Keyboard.getEventKey() == Keyboard.KEY_S
					&& Keyboard.getEventKeyState()) {
				saveMap("newMap1", grid);
			}
		}
	}

	private void setTile() {
		grid.SetTile((int) Math.floor(Mouse.getX() / 64),
				(int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64),
				types[index]);
	}
	
	private void moveIndex() {
		index++;
		if (index > types.length - 1) {
			index = 0;
		}
	}
}
