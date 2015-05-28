package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Artist.*;
public class Player {

	
	private TileGrid grid;
	private TileType[] types;
	private int index;
	
	public Player(TileGrid grid){
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.index = 0;
	}
	
	public void SetTile(){
		grid.SetTile((int)Math.floor(Mouse.getX()/64), 
				(int) Math.floor((HEIGHT  - Mouse.getY()-1)/64), types[index]);
	}
	
	public void update(){
		
		if(Mouse.isButtonDown(0)){
			SetTile();
		}
		while(Keyboard.next()){
			// Gets the right key input. Needs the getEventKeyState to make sure, 
			// that the input is passed only once, every time it key is pressed.
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()){
				MoveIndex();
			}
		}
	}
	
	private void MoveIndex(){
		index++;
		if(index > types.length - 1){
			index = 0;
		}
	}
}