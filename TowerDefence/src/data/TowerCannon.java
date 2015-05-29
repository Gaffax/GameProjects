package data;

import org.newdawn.slick.opengl.Texture;
//import static helpers.Artist.DrawQuadTex;

public class TowerCannon {

	private float x, y;
	private int width, height, damage;
	private Texture texture;
	private Tile startTile;
	
	public TowerCannon(Texture texture, Tile startTile){
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
	}
	
	public void update(){
		
	}
	
	public void draw(){
		//Another way to import
		helpers.Artist.DrawQuadTex(x, y, width, height, texture);
		
	}
}
