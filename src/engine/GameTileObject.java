package engine;

import model.tile.Tile;
import jgame.JGObject;

public class GameTileObject extends JGObject {
	
	private Tile myTile;
	private static final int myCollisionID = 0;
	private static final int mySize = 20;
	private boolean isHighlighted = false;
	
	public GameTileObject(Tile tile) {
		super("-tile", true, tilesToPixels(tile.getX()), tilesToPixels(tile.getY()), myCollisionID, tile.getStatCollection("Terrain").getID());   //all the game's images should be defined before any GameObjects are created
	} //"-tile" to ensure tiles are drawn first
	
	public static int tilesToPixels(int x) {
		return x*mySize;
	}
	
	public static int getCollisionID() {
		return myCollisionID;
	}
	
	public static int getSize() {
		return mySize;
	}
	
	public Tile getTile() {
		return myTile;
	}
	
	public void toggleIsHighlighted() {
		isHighlighted = !isHighlighted;
	}
	
	public boolean isHighlighted() {
		return isHighlighted;
	}
	
}
