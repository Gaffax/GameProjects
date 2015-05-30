package data;

import static helpers.Artist.QuickLoad;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;

	// Temp variables
	TowerCannon tower;

	public Game(int[][] map) {
		grid = new TileGrid(map);
		player = new Player(grid);
		waveManager = new WaveManager(new Enemy(QuickLoad("enemy64"), grid.GetTile(7, 7),
				grid, 64, 64, 10),
				4, 5);

		tower = new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(14, 7),
				10);
	}

	public void update() {
		grid.Draw(); // Needs to go first
		waveManager.update();
		player.update();
		tower.update();

	}
}
