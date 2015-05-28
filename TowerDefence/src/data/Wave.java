package data;

import java.util.ArrayList;
import static helpers.Clock.*;
public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	
	public Wave(float spawnTime, Enemy EnemyType){
		this.enemyType = EnemyType;
		this.spawnTime = spawnTime;
		enemyList = new ArrayList<Enemy>();
	}
	
	public void Update(){
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime){
			Spawn();
			timeSinceLastSpawn = 0;
		}
		
		for(Enemy e: enemyList){
			e.Update();
			e.Draw();
		}
	}
	public void Spawn(){
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getGrid(), 64, 64, enemyType.getSpeed()));
	}
}
