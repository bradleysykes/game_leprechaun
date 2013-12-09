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
	private Map<Unit, String> myUnitImageMap;

	public GameLoader(GameElements gameElements, GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myGameElements = gameElements;
	}

	public void loadGame() {
		myGameEngine.removeObjects("tile", GameTileObject.getCollisionID());
		myGameEngine.removeObjects("unit", GameUnitObject.getCollisionID());
		GameMap gameMap = myGameElements.getGameMap();
		if(gameMap==null) System.out.println("game map is null for some reason");
		myGameEngine.setPFSize(gameMap.getSizeX() , gameMap.getSizeY());
		Collection<Tile> allTiles = gameMap.getAllTiles();

		Map<Tile, String> myTileImages = myGameElements.getTileImageMap();
		myUnitImageMap = myGameElements.getUnitImageMap();
		
		for (Tile tile : myTileImages.keySet()) {
		    String id = tile.getStatCollection("Terrain").getID();
			System.out.println("Loading: "+ id + " "+ myTileImages.get(tile));
			myGameEngine.defineImage(id, "-", 0,  "/" + myTileImages.get(tile),"-");
		}
		
		for (Unit unit : myUnitImageMap.keySet()) {
		    String id  = unit.getID();
			System.out.println("Loading: "+id + " "+ myUnitImageMap.get(unit));
			myGameEngine.defineImage(id, "-", 0, "/" + myUnitImageMap.get(unit),"-");
		}
		
		myGameEngine.defineImage(EngineConstants.endScreenName, "-", 0, EngineConstants.endScreenPath, "-");

		Collection<Player> allPlayers = myGameElements.getPlayers();
		Collection<Unit> allUnits = new ArrayList<Unit>();
		for (Player player : allPlayers) {
			allUnits.addAll(player.getAllUnits());
			player.setModel(myGameEngine.getModel());
		}

		myGameEngine.setPlayers(allPlayers);
		myGameEngine.initializeTiles(allTiles);
		myGameEngine.initializeUnits(allUnits);
		myGameEngine.initializeGameManager();
		
		myGameEngine.declareWinner(myGameEngine.getPlayers().get(0));
	}
	
	public Map<Unit, String> getUnitImageMap() {
		return myUnitImageMap;
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
