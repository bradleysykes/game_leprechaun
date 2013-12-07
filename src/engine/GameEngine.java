package engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.GameElements;
import engine.gui.SpawnerViewer;
import engine.listeners.ViewOffsetListener;
import jgame.JGColor;
import jgame.platform.JGEngine;
import model.GameMap;
import model.Model;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;

public class GameEngine extends JGEngine implements EngineConstants {
	
	private GameManager myGameManager;
	private Model myModel;
	private GameLoader myGameLoader;
	private List<Player> myPlayers;
	private List<Unit> myUnits;
	private GameMap myGameMap;
	private Map<Tile, GameTileObject> myTileObjectMap;
	private Map<Unit, GameUnitObject> myUnitObjectMap;
	private MouseObject myMouseObject;
	private GameViewer myGameViewer;
	private ViewOffsetListener myViewListener;
	private File mySourceFile;
	private SpawnerViewer mySpawnerViewer;
	
	public GameEngine(GameViewer gv) {
		initEngineComponent(640, 480);
		myGameViewer = gv;
	}
	
	public void initCanvas() {
		setCanvasSettings(myViewerWidth/myTileWidth,  // width of the canvas in tiles
                myViewerHeight/myTileHeight,  // height of the canvas in tiles
                myTileWidth,  // width of one tile
                myTileHeight,  // height of one tile
                null,// foreground colour -> use default colour white
                JGColor.blue,// background colour -> use default colour black
                null); // standard font -> use default font);
	}
	
	public void initGame() {
		setFrameRate(5, 1);
		myMouseObject = new MouseObject(this);
		myTileObjectMap = new HashMap<Tile, GameTileObject>();
		myUnitObjectMap = new HashMap<Unit, GameUnitObject>();
		myModel = new Model(this);
		//myViewListener = new ViewOffsetListener(this);
	}
	
	public Model getModel() {
		return myModel;
	}
	
	public void doFrame() {
		//myViewListener.setOffset();
		this.moveObjects();
		this.checkCollision(MOUSE_COL_ID, 2+8);
		if (myGameManager != null) {
			myGameManager.setPlayerStatusArea();
		}
	}
	
	public void initializeState(GameElements gameElements) {
		myGameLoader = new GameLoader(gameElements, this);
		myGameLoader.loadGame();
		for(Player p : myPlayers)
			myModel.addPlayer(p);
	}
	
	public void initializeTiles(Collection<Tile> tiles) {
		for (Tile tile : tiles) {
			GameTileObject newTile = new GameTileObject(tile,this);
			myTileObjectMap.put(tile, newTile);
		}
	}
	
	public void initializeUnits(Collection<Unit> units) {
		myUnits = new ArrayList<Unit>();
		for (Unit unit : units) {
			GameUnitObject newUnit = new GameUnitObject(unit,this);
			myUnitObjectMap.put(unit, newUnit);
			myUnits.add(unit);
		}
	}
	
	public void initializeGameManager() {
		myGameManager = new GameManager(this);
	}
			
	
	public void highlightCurrentPlayer() {
		for (Unit unit : myUnits) {
			if (unit.getPlayer() == myGameManager.getCurrentPlayer()) {
				Tile tile = unit.getCurrentTile();
				new PlayerHighlightObject(tile, this);
			}
		}
	}
	
	public void removeCurrentPlayerHighlights() {
		removeObjects(EngineConstants.PlayerHighlightName, EngineConstants.PlayerHighlight_COL_ID);
	}
	
	public void highlightTiles(List<Tile> tileList) {
		for (Tile tile : tileList) {
			new TileHighlightObject(tile, this);
			myTileObjectMap.get(tile).setHighlighted(true);
		}
	}
	
	public void removeTileHighlights() {
		for (Tile tile : myTileObjectMap.keySet()) {
			if (myTileObjectMap.get(tile).isHighlighted()) myTileObjectMap.get(tile).setHighlighted(false);
		}
		removeObjects(EngineConstants.TileHighlightName, EngineConstants.TileHighlight_COL_ID);
	}
	
	public void destroyUnit(Unit unit) {
		removeObject(myUnitObjectMap.get(unit));
		myUnits.remove(unit);
		myUnitObjectMap.remove(unit);
	}
	
	public void spawnUnit(Unit unit) {
		GameUnitObject newUnit = new GameUnitObject(unit, this);
		myUnitObjectMap.put(unit, newUnit);
		myUnits.add(unit);
	}
	
	public void initializeSpawner(List<Unit> unitList) {
		if (mySpawnerViewer == null) {
			mySpawnerViewer = new SpawnerViewer(unitList, this);
		} else {
			mySpawnerViewer.pack();
			mySpawnerViewer.setVisible(true);
			mySpawnerViewer.getSpawnerPanel().setListContent(unitList);
		}
		
	}
	
	public static int getViewerWidth() {
		return myViewerWidth;
	}
	
	public static int getViewerHeight() {
		return myViewerHeight;
	}
	
	public GameTileObject getGameTile(Tile tile){
		return myTileObjectMap.get(tile);
	}
	
	public void setPlayers(Collection<Player> players) {
		myPlayers = (List<Player>) players;
	}
	
	public List<Player> getPlayers() {
		return myPlayers;
	}
	
	public void setSelectedUnit(Unit u){
		myGameViewer.setSelectedUnit(u);
	}
	
	public void sendModelUnit(Unit u){
		myModel.useAbility(u);		// For sending a newly created unit from the list of strings,
									// with one string selected by player (Spawning).
	}
	
	public void requestStringFromList(List<String> list){
		// Display list of spawnable units to user, allow them to select one.
		// Ideally, eventually have Portrait displayed for each spawnable unit.
		// This will lead to 'sendModelUnit' being called.
	}

	public void setSourceFile(File file) {
		mySourceFile = file;
	}

	public File getSourceFile() {
		return mySourceFile;
	}
	
	public GameManager getGameManager() {
		return myGameManager;
	}
	
	public GameLoader getGameLoader() {
		return myGameLoader;
	}
	
	public GameViewer getGameViewer() {
		return myGameViewer;
	}

	public void declareWinner(Player p) {
		// Engine - this is how we will tell you that somebody has won the game.
	}
	
}
