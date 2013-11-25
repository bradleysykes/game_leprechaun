package engine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;

import data.GameElements;
import jgame.JGColor;
import jgame.platform.JGEngine;
import model.GameMap;
import model.Model;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;

public class GameEngine extends JGEngine {
	
	private GameManager myGameManager;
	private Model myModel;
	private GameLoader myGameLoader;
	private static final int myViewerWidth = 800;
	private static final int myViewerHeight = 500;
	private final int myTileWidth = 20;
	private final int myTileHeight = 20;
	private ArrayList<Unit> myUnits;
	private GameMap myGameMap;
	private Map<Tile, GameTileObject> myTileObjectMap;
	private ArrayList<Player> myPlayers;
	private Player myCurrentPlayer;
	private MouseObject myMouseObject;
	
	public GameEngine() {
		initEngineComponent(myViewerWidth, myViewerHeight);
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
		setFrameRate(35, 1);
		myMouseObject = new MouseObject(this);
		myTileObjectMap = new HashMap<Tile, GameTileObject>();
		myModel = new Model(this);
	}
	
	public Model getModel() {
		return myModel;
	}
	
	public void doFrame() {
		this.moveObjects();
		checkCollision(GameTileObject.getCollisionID(), MouseObject.getCollisionID());
		if (getMouseButton(1)){
			clearMouseButton(1);
			System.out.println(this.countObjects(null, 0));
		}
	}
	
	public void nextPlayer() {
		
	}
	
	public Player getCurrentPlayer() {
		return myCurrentPlayer;
	}
	
	public ArrayList<Player> getPlayers() {
		return myPlayers;
	}
	
	public void setPlayers(Collection<Player> players) {
		myPlayers = (ArrayList<Player>) players;
	}
	
	public void initializeState(GameElements gameElements) {
		myGameLoader = new GameLoader(gameElements, this);
		myGameLoader.loadGame();
	}
	
	public void initializeTiles(Collection<Tile> tiles) {
		for (Tile tile : tiles) {
			GameTileObject newTile = new GameTileObject(tile,this);
			myTileObjectMap.put(tile, newTile);
		}
	}
	
	public void initializeUnits(Collection<Unit> units) {
		for (Unit unit : units) {
			GameUnitObject newUnit = new GameUnitObject(unit,this);
		}
	}
	
	public void highlightTiles(List<Tile> tileList) {
		for (Tile tile : tileList) {
			TileHighlightObject highlight = new TileHighlightObject(tile, this);
			myTileObjectMap.get(tile).toggleIsHighlighted();
		}
	}
	
	public void removeHighlights() {
		for (Tile tile : myTileObjectMap.keySet()) {
			if (myTileObjectMap.get(tile).isHighlighted()) myTileObjectMap.get(tile).toggleIsHighlighted();
		}
		removeObjects("zhighlight", TileHighlightObject.getCollisionID()); //not a typo it actually is "zhighlight"
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
	
	public void sendModelUnit(Unit u){
		myModel.useAbility(u);		// For sending a newly created unit from the list of strings,
									// with one string selected by player (Spawning).
	}
	
	public void requestStringFromList(List<String> list){
		// Display list of spawnable units to user, allow them to select one.
		// Ideally, eventually have Portrait displayed for each spawnable unit.
		// This will lead to 'sendModelUnit' being called.
	}
	
}
