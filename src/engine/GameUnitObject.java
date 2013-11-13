package engine;

import model.unit.Unit;
import jgame.JGObject;

public class GameUnitObject extends JGObject {
	
	private Unit myUnit;
	private static final int myCollisionID = 2;

	public GameUnitObject(Unit unit) {
		super("unit", true, GameTileObject.tilesToPixels(unit.getCurrentTile().getX()), GameTileObject.tilesToPixels(unit.getCurrentTile().getY()),
				myCollisionID, unit.getName());
	}
	
	public static int getCollisionID() {
		return myCollisionID;
	}
	
	
}
