package data;

import static helpers.Artist.QuickLoad;

public class Game {

	private TileGrid grid;
	private Player player;
	private Wave wave;

	// Temp variables
	TowerCannon tower;

	public Game(int[][] map) {
		grid = new TileGrid(map);
		player = new Player(grid);
		wave = new Wave(20, new Enemy(QuickLoad("enemy64"), grid.GetTile(7, 7),
				grid, 64, 64, 8));

		tower = new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(14, 7),
				10);
	}

	public void update() {
		grid.Draw(); // Needs to go first
		wave.Update();
		player.update();
		tower.update();

	}
}
