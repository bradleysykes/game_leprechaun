package engine;

import java.util.*;

import engine.gui.AbilityListArea;
import engine.gui.UnitListArea;
import engine.gui.UnitStatusArea;
import model.tile.Tile;
import model.unit.Unit;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class GameTileObject extends JGObject implements EngineConstants{

	private Tile myTile;
	private static final int myCollisionID = 8;
	private static final int mySize = 79;
	private boolean isHighlighted = false;
	private GameEngine myEngine;

	public GameTileObject(Tile tile, GameEngine engine) {
		super("tile", true, 0, 0, 
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

	public void setHighlighted(boolean highlighted) {
		isHighlighted = highlighted;
	}

	public boolean isHighlighted() {
		return isHighlighted;
	}

	@Override
	public void hit(JGObject other){
		if (other.colid == MOUSE_COL_ID && myEngine.getMouseButton(1)) {
			myEngine.clearMouseButton(1);
			if (this.isHighlighted()) { 
				myEngine.getModel().useAbility(myTile);
				myEngine.removeTileHighlights();
				return;
			}
			myEngine.removeTileHighlights();
			
			List<Unit> unitList = myTile.getUnits();
			List<Unit> selectableUnitList = new ArrayList<Unit>();
			for (Unit unit : unitList) {
				if (myEngine.getGameManager().getCurrentPlayer().equals(unit.getPlayer())) {
					selectableUnitList.add(unit);
				}
			}
			for (Unit unit : unitList) {
				System.out.println(unit.getID());
			}
			AbilityListArea abilityListArea = (AbilityListArea) GameViewer.getActionPanel().getAbilityListArea();
			abilityListArea.clear();
			UnitStatusArea unitStatusArea = (UnitStatusArea) GameViewer.getFeedbackPanel().getUnitStatusArea();
			unitStatusArea.setStatusText("");
			UnitListArea unitListArea = (UnitListArea) GameViewer.getActionPanel().getUnitListArea();
			unitListArea.loadUnitList(selectableUnitList);
		}
	}

}
