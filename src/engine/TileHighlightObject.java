package engine;

import jgame.JGColor;
import jgame.JGObject;
import model.tile.Tile;

public class TileHighlightObject extends JGObject {
	
	private Tile myTile;
	private GameEngine myGameEngine;
	private static final int myCollisionID = 4;
	private final double myThickness = 3;
	private final JGColor myColor = JGColor.black;
	
	public TileHighlightObject(Tile tile, GameEngine gameEngine) {
		super("zhighlight", true, GameTileObject.tilesToPixels(tile.getX()), GameTileObject.tilesToPixels(tile.getY()), myCollisionID, null);
		myTile = tile;    //"zhighlight so that it is draw last.. need to find a better way of doing this"
		myGameEngine = gameEngine;
	}
	
	public void paint() {
		double size = GameTileObject.getSize();
		myGameEngine.drawRect(GameTileObject.tilesToPixels(myTile.getX()), GameTileObject.tilesToPixels(myTile.getY()), 
				GameTileObject.getSize(), GameTileObject.getSize(), false, false, myThickness, myColor);
	}
	
}
