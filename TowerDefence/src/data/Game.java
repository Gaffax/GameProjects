package data;

import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;


	public Game(int[][] map) {
		grid = new TileGrid(map);

		waveManager = new WaveManager(new Enemy(QuickLoad("UFO64"),
				grid.getTile(7, 7), grid, TILE_SIZE, TILE_SIZE, 10, 25), 2, 2);
		player = new Player(grid, waveManager);
	}

	public void update() {
		grid.draw(); // Needs to go first
		waveManager.update();
		player.update();
	}
}
