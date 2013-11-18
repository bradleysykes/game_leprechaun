package engine;

import model.tile.Tile;
import jgame.JGObject;

public class GameTileObject extends JGObject {
	
	private Tile myTile;
	private static final int myCollisionID = 0;
	private static final int mySize = 20;
	
	public GameTileObject(Tile tile, String imageName) {
		super("tile", true, tilesToPixels(tile.getX()), tilesToPixels(tile.getY()), myCollisionID, imageName);   //all the game's images should be defined before any GameObjects are created
	}
	
	public static int tilesToPixels(int x) {
		return x*mySize;
	}
	
	public static int getCollisionID() {
		return myCollisionID;
	}
	
	public static int getSize() {
		return mySize;
	}
	
}
