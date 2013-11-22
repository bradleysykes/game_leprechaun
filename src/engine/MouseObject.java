package engine;

import java.util.List;

import engine.gui.UnitListArea;
import model.Ability;
import model.Model;
import model.tile.Tile;
import model.unit.Unit;
import jgame.JGObject;

public class MouseObject extends JGObject {
	
	private GameEngine myGameEngine;
	private static final int myCollisionID = 8;
	
	public MouseObject(GameEngine gameEngine) {
		super("mouse", false, gameEngine.getMouseX(), gameEngine.getMouseY(), myCollisionID, null);
		myGameEngine = gameEngine;
	}
	
	public void move() {
		x = myGameEngine.getMouseX();
		y = myGameEngine.getMouseY();
	}
	
	public void hit(JGObject object) {
		if (object.colid == GameTileObject.getCollisionID()) {
			GameTileObject gameTile = (GameTileObject) object;
			Tile tile = gameTile.getTile();
			if (gameTile.isHighlighted()) { 
				Model.useAbility(tile);
				return;
			}
			List<Unit> unitList = tile.getUnits();
			UnitListArea unitListArea = (UnitListArea) GameViewer.getActionPanel().getUnitListArea();
			unitListArea.loadUnitList(unitList);
		}
	}
	
}
