package data;

public enum TileType {
	
	Grass("grass64", true), Dirt("dirt64",false), Water("water64", false), NULL("water64", false);//First parameter: Graphics, second parameter: Build tower possible?
	
	private String textureName;
	private boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.setTextureName(textureName);
		this.buildable = buildable;
	}

	public String getTextureName() {
		return textureName;
	}

	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}
}
