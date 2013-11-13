package engine;

import model.tile.Tile;
import jgame.JGObject;

public class GameTileObject extends JGObject {
	
	Tile myTile;
	
	public GameTileObject(String name, boolean uniqueID, double x, double y,
			int collisionID, String GFXname) {
		super(name, uniqueID, x, y, collisionID, GFXname);
	}
	
}
