package engine;

import model.tile.Tile;
import jgame.JGColor;
import jgame.JGObject;

public class HighlightObject extends JGObject {
	
	protected Tile myTile;
	protected GameEngine myGameEngine;
	protected final double myThickness = 3;
	protected final JGColor myColor;
	
	public HighlightObject(String name, int colid, Tile tile, GameEngine gameEngine, JGColor color) {
		super(name, true, 0, 0, colid, null);
		myTile = tile;
		myGameEngine = gameEngine;
		myColor = color;
	}
	
	public void paint() {
		myGameEngine.drawRect(myTile.getX()*myGameEngine.getGameTile(myTile).getImageBBox().width, 
				myTile.getY()*myGameEngine.getGameTile(myTile).getImageBBox().height, 
				myGameEngine.getGameTile(myTile).getImageBBox().width, 
				myGameEngine.getGameTile(myTile).getImageBBox().height, false, false, myThickness, myColor);
	}
	
}
