package data;

import java.util.ArrayList;
import static helpers.Clock.*;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	private int enemiesPerWave;

	public Wave(Enemy EnemyType, float spawnTime, int enemiesPerWave) {
		this.enemyType = EnemyType;
		this.spawnTime = spawnTime;
		enemyList = new ArrayList<Enemy>();
		
		Spawn();
	}

	public void Update() {
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			Spawn();
			timeSinceLastSpawn = 0;
		}

		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				e.Update();
				e.Draw();
			}
		}
	}

	public void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType
				.getStartTile(), enemyType.getGrid(), 64, 64, enemyType
				.getSpeed()));
	}
}
