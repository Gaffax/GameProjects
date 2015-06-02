package data;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Artist.*;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private int index;
	private WaveManager waveManager;
	private ArrayList<TowerCannon> towerList;
	private boolean leftMouseButtonDown = false;

	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.index = 0;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<TowerCannon>();

	}

	public void setTile() {
		grid.SetTile((int) Math.floor(Mouse.getX() / 64),
				(int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64),
				types[index]);
	}

	public void update() {

		for (TowerCannon t : towerList)
			t.update();

		// Handle mouse input

		// One click, one update.
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid
					.GetTile(Mouse.getX() / 64, (HEIGHT - Mouse.getY() - 1)/64), 10,
					waveManager.getCurrentWave().getEnemyList()));
			// setTile();
		}

		// Makes sure that the mouse button state is reset.
		// Without this, the holding the mouse down would produce
		// a click per time the game updated. Which is alot over
		// over a few seconds.
		leftMouseButtonDown = Mouse.isButtonDown(0);

		// Handle keyboard input
		while (Keyboard.next()) {
			// Gets the right key input. Needs the getEventKeyState to make
			// sure,
			// that the input is passed only once, every time it key is pressed.
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT
					&& Keyboard.getEventKeyState()) {
				moveIndex();
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_T
					&& Keyboard.getEventKeyState()) {
				towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid
						.GetTile(18, 9), 10, waveManager.getCurrentWave()
						.getEnemyList()));
			}
		}
	}

	private void moveIndex() {
		index++;
		if (index > types.length - 1) {
			index = 0;
		}
	}
}