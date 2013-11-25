package engine;

import java.util.List;

import engine.gui.UnitListArea;
import model.tile.Tile;
import model.unit.Unit;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class GameTileObject extends JGObject implements EngineConstants{

	private Tile myTile;
	private static final int myCollisionID = 0;
	private static final int mySize = 79;
	private boolean isHighlighted = false;
	private GameEngine myEngine;

	public GameTileObject(Tile tile, GameEngine engine) {
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

	@Override
	public void hit(JGObject other){
		if (other.colid == MOUSE_COL_ID) {
			if (this.isHighlighted()) { 
				myEngine.getModel().useAbility(myTile);
				myEngine.removeHighlights();
				return;
			}
			List<Unit> unitList = myTile.getUnits();
			UnitListArea unitListArea = (UnitListArea) GameViewer.getActionPanel().getUnitListArea();
			unitListArea.loadUnitList(unitList);
		}
	}

}
