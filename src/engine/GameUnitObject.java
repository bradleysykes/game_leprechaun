package engine;

import model.unit.Unit;
import jgame.JGObject;

public class GameUnitObject extends JGObject {

	public GameUnitObject(Unit unit, String name, boolean uniqueID, double x, double y,
			int collisionID, String GFXname) {
		super(name, uniqueID, x, y, collisionID, GFXname);
		
	}
	
	
}
