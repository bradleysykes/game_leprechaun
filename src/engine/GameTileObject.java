package engine;

import model.tile.Tile;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class GameTileObject extends JGObject {

	private Tile myTile;
	private static final int myCollisionID = 0;
	private static final int mySize = 79;
	private boolean isHighlighted = false;
	private JGEngine myEngine;

	public GameTileObject(Tile tile, JGEngine engine) {
		super("-tile", true, 0, 0, 
				myCollisionID, tile.getStatCollection("Terrain").getID());
		myEngine = engine;
		myTile = tile;
	} 
	
	@Override
	public void move(){
		this.setPos(myTile.getX()*this.getImageBBox().width, myTile.getY()*this.getImageBBox().height);
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
