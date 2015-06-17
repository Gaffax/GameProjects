package data;

import static helpers.Artist.HEIGHT;
import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private WaveManager waveManager;
	private ArrayList<TowerCannon> towerList;
	private boolean leftMouseButtonDown = false;

	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<TowerCannon>();

	}

	public void update() {

		for (TowerCannon t : towerList) {
			t.update();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		// Handle mouse input

		// One click, one update.
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid
					.getTile(Mouse.getX() / 64,
							(HEIGHT - Mouse.getY() - 1) / TILE_SIZE), 10, 1000,
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
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT
					&& Keyboard.getEventKeyState()) {

			}
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT
					&& Keyboard.getEventKeyState()) {

			}

			if (Keyboard.getEventKey() == Keyboard.KEY_T
					&& Keyboard.getEventKeyState()) {
				towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid
						.getTile(18, 9), 10, 1000, waveManager.getCurrentWave()
						.getEnemyList()));
			}
		}
	}
}