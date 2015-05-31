package data;

import static helpers.Artist.QuickLoad;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;



	public Game(int[][] map) {
		grid = new TileGrid(map);

		waveManager = new WaveManager(new Enemy(QuickLoad("enemy64"), grid.GetTile(7, 7),
				grid, 64, 64, 10),
				2, 2);
		player = new Player(grid, waveManager);
	}

	public void update() {
		grid.Draw(); // Needs to go first
		waveManager.update();
		player.update();

	}
}
