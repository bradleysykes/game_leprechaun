package engine;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import data.GameElements;
import java.util.Collection;
import java.util.Map;
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
		myGameEngine.setPFSize(gameMap.getSizeX() , gameMap.getSizeY());
		Collection<Tile> allTiles = gameMap.getAllTiles();

		Map<String, String> myTileImages = myGameElements.getTileImageMap();
		Map<String, String> myUnitImages = myGameElements.getUnitImageMap();

		for (String id : myTileImages.keySet()) {
			myGameEngine.defineImage(id, "-", 0,  "/" + myTileImages.get(id),"-");
		}		
		
		for (String id : myUnitImages.keySet()) {
			myGameEngine.defineImage(id, "-", 0, "/" + myUnitImages.get(id),"-");
		}

		Collection<Player> allPlayers = myGameElements.getPlayers();
		Collection<Unit> allUnits = new ArrayList<Unit>();
		for (Player player : allPlayers) {
			allUnits.addAll(player.getAllUnits());
		}

		myGameEngine.setPlayers(allPlayers);
		myGameEngine.initializeTiles(allTiles);
		myGameEngine.initializeUnits(allUnits);
		myGameEngine.initializeGameManager();
	}
	
	/**
	 * This method converts the abolute path into the relative path.
	 * However, it will only work in linux or Mac OS because JGEngine
	 * adds the string, "/", to the front.
	 * 
	 * @param path
	 * @return
	 */
	private String getRelativePath(String path) {
        String rootDir = System.getProperty("user.dir");
        Path basePath = Paths.get(rootDir);
        Path absolutePath = Paths.get(path);
        return basePath.relativize(absolutePath).toString(); 
	}
}
