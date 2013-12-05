package engine;

import jgame.JGColor;
import jgame.JGObject;
import model.tile.Tile;

public class TileHighlightObject extends HighlightObject {

	public TileHighlightObject(Tile tile, GameEngine gameEngine) {
		super(EngineConstants.TileHighlightName, EngineConstants.TileHighlight_COL_ID, tile, gameEngine, EngineConstants.TileHighlightColor);
	}
	
	
	
	
//	private Tile myTile;
//	private GameEngine myGameEngine;
//	private final double myThickness = 3;
//	private final JGColor myColor = JGColor.cyan;
//	
//	
//	public TileHighlightObject(Tile tile, GameEngine gameEngine) {
//		super(EngineConstants.TileHighlightName, true, 0, 0, EngineConstants.TileHighlight_COL_ID, null);
//		myTile = tile;   
//		myGameEngine = gameEngine;
//	}
//	
//	@Override
//	public void paint() {
//		myGameEngine.drawRect(myTile.getX()*myGameEngine.getGameTile(myTile).getImageBBox().width, 
//				myTile.getY()*myGameEngine.getGameTile(myTile).getImageBBox().height, 
//				myGameEngine.getGameTile(myTile).getImageBBox().width, 
//				myGameEngine.getGameTile(myTile).getImageBBox().height, false, false, myThickness, myColor);
//	}
//	
//	public static int getCollisionID() {
//		return myCollisionID;
//	}
	
}
