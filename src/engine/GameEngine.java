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
	private boolean gameOver = false;
	private Player myWinner = null;
	
	public GameEngine(GameViewer gv) {
		initEngineComponent(myViewerWidth, myViewerHeight);
		myGameViewer = gv;
	}
	
	public void initCanvas() {
		setCanvasSettings(myViewerWidth/myTileWidth,  // width of the canvas in tiles
                myViewerHeight/myTileHeight,  // height of the canvas in tiles
                myTileWidth,  // width of one tile
                myTileHeight,  // height of one tile
                null,// foreground colour -> use default colour white
                JGColor.black,// background colour -> use default colour black
                null); // standard font -> use default font);
	}
	
	public void initGame() {
		setFrameRate(20, 1);
		myViewListener = new ViewOffsetListener(this);
		myMouseObject = new MouseObject(this, myViewListener);
		myTileObjectMap = new HashMap<Tile, GameTileObject>();
		myUnitObjectMap = new HashMap<Unit, GameUnitObject>();
		myModel = new Model(this);
	}
	
	public Model getModel() {
		return myModel;
	}
	
	public void doFrame() {
		myViewListener.setOffset();
		this.moveObjects();
		this.checkCollision(MOUSE_COL_ID, 2+8);
		if (myGameManager != null) {
			myGameManager.setPlayerStatusArea();
		}
	}
	
	public void paintFrame() {
		if (gameOver) {
			drawImage(0, 0, endScreenName);
			drawString(myWinner.getID() + " wins!", (double) myViewerWidth/2, (double) myViewerHeight/2, 0, false);
		}
	}
	
	public void initializeState(GameElements gameElements) {
		myGameLoader = new GameLoader(gameElements, this);
		myGameLoader.loadGame();
		for(Player p : myPlayers)
			myModel.addPlayer(p);
		myModel.refresh();
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
		// remove spawn units prompt, as queued ability is no longer requesting unit return.
		for (Tile tile : tileList) {
			new TileHighlightObject(tile, this);
			myTileObjectMap.get(tile).setHighlighted(true);
		}
	}
	
	public void removeTileHighlights() {
		for (Tile tile : myTileObjectMap.keySet()) {
			if (myTileObjectMap.get(tile).isHighlighted()) myTileObjectMap.get(tile).setHighlighted(false);
		}
		removeObjects(TileHighlightName, TileHighlight_COL_ID);
	}
	
	public void highlightSelection(GameTileObject gameTileObject) {
		new SelectionHighlightObject(gameTileObject.getTile(), this);
	}
	
	public void removeSelectionHighlight() {
		removeObjects(SelectionHighlightName, SelectionHighlight_COL_ID);
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
		myGameManager.getCurrentPlayer().addUnit(unit);
		//add to player, tile
	}
	
	public void initializeSpawner(List<String> unitIDList) {
		List<Unit> unitList = new ArrayList<Unit>();
		for (String id : unitIDList) {
			for (Unit unit : myGameLoader.getUnitImageMap().keySet()) { //ugly...
				if (id.equals(unit.getID().split("\\|")[0])) {
					unitList.add(unit);
				}
			}
		}
		for (Unit unit : unitList) {
			System.out.println(unit.getID());
		}
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
	
	public MouseObject getMouseObject() {
		return myMouseObject;
	}

	public void declareWinner(Player p) {
		// Engine - this is how we will tell you that somebody has won the game.
		removeAllObjects();
		myWinner = p;
		gameOver = true;
	}
	
	private void removeAllObjects() {
		removeObjects("tile", 8);
		removeObjects("unit", 2);
		removeObjects(TileHighlightName, TileHighlight_COL_ID);
		removeObjects(PlayerHighlightName, PlayerHighlight_COL_ID);
	}
	
}
