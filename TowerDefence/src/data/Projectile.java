package data;

import helpers.Artist;

import org.newdawn.slick.opengl.Texture;

import static helpers.Clock.*;
import static helpers.Artist.*;

public class Projectile implements Entity{

	private Texture texture;
	private float x, y, speed, xVelocity, yVelocity;
	private int damage, width, height;
	private boolean isAlive;
	private Enemy target;

	public Projectile(Texture texture, Enemy target, float x, float y,
			int width, int height, float speed, int damage) {
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
		// Compensating for the projectiles size
		float xDistanceFromTarget = Math.abs(target.getX() - x - TILE_SIZE
				/ 4 + Artist.TILE_SIZE / 2);
		float yDistanceFromTarget = Math.abs(target.getY() - y - TILE_SIZE
				/ 4 + Artist.TILE_SIZE / 2);
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
		if (isAlive) {
			x += xVelocity * speed * Delta();
			y += yVelocity * speed * Delta();
			if (CheckCollision(x, y, width, height, target.getX(),
					target.getY(), target.getWidth(), target.getHeight())) {
				target.damage(damage);
				isAlive = false;
			}
			draw();
		}
	}

	public void draw() {
		DrawQuadTexture(x, y, 32, 32, texture);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
		
	}

	public void setY(float y) {
		this.y = y;		
	}

	public void setWidth(int width) {
		this.width = width;		
	}

	public void setHeight(int height) {
		this.height = height;
		
	}
}
