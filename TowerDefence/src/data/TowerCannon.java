package data;

import helpers.Artist;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
import static helpers.Clock.*;

public class TowerCannon {

	private float x, y, timeSinceLastShot, firingSpeed, angle;
	private int width, height, damage, range;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Enemy> enemies;
	private Enemy target;
	private boolean targeted;

	public TowerCannon(Texture baseTexture, Tile startTile, int damage,
			int range, ArrayList<Enemy> enemies) {
		this.baseTexture = baseTexture;
		this.cannonTexture = QuickLoad("cannonGun");
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.damage = damage;
		this.range = range;
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.firingSpeed = 3;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
		this.enemies = enemies;
		this.targeted = false;
	}

	private Enemy aquireTarget() {
		Enemy closest = null;
		float closestDistance = 10000;
		for (Enemy e : enemies) {
			if (isInRange(e) && findDistance(e) < closestDistance) {
				closestDistance = findDistance(e);
				closest = e;
			}
		}
		if (closest != null)
			targeted = true;
		return closest;
	}

	private float findDistance(Enemy e) {
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		return xDistance + yDistance;
	}

	private boolean isInRange(Enemy e) {
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getX() - y);
		if (xDistance < range && yDistance < range)
			return true;
		return false;
	}

	private float calculateAngle() {
		double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
		return (float) Math.toDegrees(angleTemp) - 90;
	}

	private void shoot() {
		timeSinceLastShot = 0;
		projectiles.add((new Projectile(QuickLoad("bullet"), target, x
				+ TILE_SIZE / 2 - TILE_SIZE / 4, y + TILE_SIZE
				/ 2 - Artist.TILE_SIZE / 4, 32, 32, 200, 10)));

	}

	public void updateEnemyList(ArrayList<Enemy> newList) {
		enemies = newList;
	}

	public void update() {

		if (!targeted) {
			target = aquireTarget();
		}

		if (target == null || target.isAlive() == false) {
			targeted = false;
		}

		timeSinceLastShot += Delta();
		if (timeSinceLastShot > firingSpeed)
			shoot();

		for (Projectile p : projectiles)
			p.update();

		angle = calculateAngle();
		draw();
	}

	public void draw() {

		DrawQuadTexture(x, y, width, height, baseTexture);
		DrawQuadTextureRotate(x, y, width, height, cannonTexture, angle);
	}
}
