package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Clock.*;
import static helpers.Artist.*;

public class Projectile {

	private Texture texture;
	private float x, y, width, height, speed, xVelocity, yVelocity;
	private int damage;
	private boolean isAlive;
	private Enemy target;

	public Projectile(Texture texture, Enemy target, float x, float y,
			float width, float height, float speed, int damage) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.damage = damage;
		this.target = target;
		this.isAlive = true;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		calculateDirection();
	}

	private void calculateDirection() {
		float totalAlloweMovement = 1.0f;
																//Compensating for the projectiles size
		float xDistanceFromTarget = Math.abs(target.getX() - x - Game.TILE_SIZE / 4
				+ Game.TILE_SIZE / 2);
		float yDistanceFromTarget = Math.abs(target.getY() - y - Game.TILE_SIZE / 4
				+ Game.TILE_SIZE / 2);
		float totalDistanceFromTarget = xDistanceFromTarget
				+ yDistanceFromTarget;
		float xPercentOfMovement = xDistanceFromTarget
				/ totalDistanceFromTarget;
		xVelocity = xPercentOfMovement;
		yVelocity = totalAlloweMovement - xPercentOfMovement;

		if (target.getX() < x)
			xVelocity *= -1;
		if (target.getY() < y)
			yVelocity *= -1;
	}

	public void update() {
		x += xVelocity * speed * Delta();
		y += yVelocity * speed * Delta();
		if(checkCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight()))
			System.out.println("Protectule hit it's target");
		draw();
	}

	public void draw() {
		DrawQuadTexture(x, y, 32, 32, texture);
	}
}
