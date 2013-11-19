package engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import data.GameElements;
import jgame.JGColor;
import jgame.platform.JGEngine;
import model.GameMap;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;

public class GameEngine extends JGEngine {
	
	private GameManager myGameManager;
	private GameLoader myGameLoader;
	private final int myViewerWidth = 600;
	private final int myViewerHeight = 450;
	private final int myTileWidth = 20;
	private final int myTileHeight = 20;
	private ArrayList<Unit> myUnits;
	private GameMap myGameMap;
	private ArrayList<Player> myPlayers;
	private Player myCurrentPlayer;
	
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
	}
	
	public void doFrame() {
		
	}
	
	public void checkCollision() {
		
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
			GameTileObject newTile = new GameTileObject(tile);
		}
	}
	
	public void initializeUnits(Collection<Unit> units) {
		for (Unit unit : units) {
			GameUnitObject newUnit = new GameUnitObject(unit);
		}
	}
	
}
