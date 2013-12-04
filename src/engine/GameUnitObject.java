package engine;

import model.unit.Unit;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class GameUnitObject extends JGObject implements EngineConstants{
	
	private Unit myUnit;
	private GameEngine myEngine;
	private static final int myCollisionID = 2;

	public GameUnitObject(Unit unit, GameEngine engine) {
		super("unit", true, 0, 0,
				myCollisionID, unit.getID());
		myUnit = unit;
		myEngine = engine;
	}
	
	@Override
	public void move(){
		this.setPos(myUnit.getCurrentTile().getX()*myEngine.getGameTile(myUnit.getCurrentTile()).getImageBBox().width
				, myUnit.getCurrentTile().getY()*myEngine.getGameTile(myUnit.getCurrentTile()).getImageBBox().height);
	}
	
	public static int getCollisionID() {
		return myCollisionID;
	}
	
	@Override
	public void hit(JGObject other){
//		if(other.colid == MOUSE_COL_ID){
//			myEngine.setSelectedUnit(myUnit);
//		}
	}
	
	
}
