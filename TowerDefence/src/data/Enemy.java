package data;
import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Enemy {

	private int width, height, health;
	private float speed, x, y;
	Texture texture;
	private Tile startTile;
	private boolean first = true;
	private TileGrid grid;
	
	private ArrayList<Checkpoint> checkpoints;
	private int[] directions;
	
	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, 
			float speed){
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.grid = grid;
		
		this.checkpoints = new ArrayList<Checkpoint>();
		this.directions = new int[2];
		//X direction
		this.directions[0] = 0;
		// Y direction
		this.directions[1] = 0;

		directions = findNextD(startTile);
	}

	public void Update(){
		
		
		/*
		 * Update is calculated with delta, and thus the first update
		 * will take much longer than all others. This is due to the
		 * game setting up everything on the first update.
		 */
		
		if(first){
			first = false;
		} else {
			x += Delta() * directions[0];
			y += Delta() * directions[1];
		}
	}
	
	private Checkpoint FindNext(Tile s, int[] dir){
		Tile next = null;
		Checkpoint c = null;
		
		boolean found = false;
		int counter = 1;
		
		while(!found){
			
			if(s.getType() != 
					grid.GetTile(s.getXPlace() + dir[0] * counter, 
					s.getYPlace() + dir[1] * counter).getType()){
				found = true;
				
				//Move counter back 1 to find tile before new tileType.
				counter -= 1;
				
				next = grid.GetTile(s.getXPlace() + dir[0] * counter, 
					s.getYPlace() + dir[1] * counter);
			}
			
			counter++;
		}
		
		c = new Checkpoint(next, dir[0], dir[1]);
		return c;
	}
	
	private int[] findNextD(Tile s){
		int[] dir = new int [2];
		Tile up = grid.GetTile(s.getXPlace(), s.getYPlace() - 1);
		Tile right = grid.GetTile(s.getXPlace() + 1, s.getYPlace());
		Tile down = grid.GetTile(s.getXPlace(), s.getYPlace() + 1);
		Tile left = grid.GetTile(s.getXPlace() - 1, s.getYPlace());
		
		if(s.getType() == up.getType()){
			dir[0] = 0;
			dir[1] = -1;
		} else if (s.getType() == right.getType()){
			dir[0] = 1;
			dir[1] = 0;
		} else if (s.getType() == down.getType()){
			dir[0] = 0;
			dir[1] = 1;
		} else if (s.getType() == left.getType()){
			dir[0] = -1;
			dir[1] = 0;
		} else {
			System.out.println("NO DIRECTION FOUND"); //DEBUGGING
		}
		
		return dir;	
	}
	/*
	private boolean pathContinues(){
		boolean answer = true;
		
		Tile myTile = grid.GetTile((int)(x / 64), (int)(y / 64));
		Tile nextTile = grid.GetTile((int)(x / 64) +1, (int)(y / 64));
		
		if (myTile.getType() != nextTile.getType())
			answer = false;
		
		return answer;
	}
	*/
	
	public void Draw(){
		DrawQuadTex(x, y, width, height,texture);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public TileGrid getGrid() {
		return grid;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}
	
	
}
