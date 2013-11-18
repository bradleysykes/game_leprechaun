package engine;

import java.util.ArrayList;
import data.GameElements;
import java.util.Collection;
import java.util.HashMap;

import model.GameMap;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;

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
		HashMap<String, String> myImages = myGameElements.getImages();
		
		for (String all : myImages.keySet()) {
			myGameEngine.defineImage(all, "-", 0, myImages.get(all),"-");
		}
		
		Collection<Player> allPlayers = myGameElements.getPlayers();
		Collection<Unit> allUnits = new ArrayList<Unit>();
		for (Player player : allPlayers) {
			allUnits.addAll(player.getAllUnits());
		}
		
		myGameEngine.initializeTiles(allTiles);
		myGameEngine.initializeUnits(allUnits);
	
		
		//load here when.. still need image information from gamedata
	}
	
}
