package engine;

import java.util.Collection;

import model.GameMap;
import model.tile.Tile;
import data.decoder.GameElements;

public class GameLoader  {
	
	private GameEngine myGameEngine;
	private GameElements myGameElements;
	
	public GameLoader(GameElements gameElements, GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myGameElements = gameElements;
	}
	
	public void loadGame() {
		myGameEngine.removeObjects("tile", GameTileObject.getCollisionID());
		myGameEngine.removeObjects("unit", GameUnitObject.getCollisionID());
		GameMap gameMap = myGameElements.getGameMap();
		Collection<Tile> allTiles = gameMap.getAllTiles();
		
	
		
		//load here when.. still need image information from gamedata
	}
	
}
