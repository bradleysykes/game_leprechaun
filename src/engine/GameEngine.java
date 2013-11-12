package engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import jgame.JGColor;
import jgame.platform.JGEngine;
import model.*;
import model.tile.Tile;
import model.unit.Unit;

public class GameEngine extends JGEngine {
	
	private GameManager myGameManager;
	private final int myViewerWidth = 800;
	private final int myViewerHeight = 600;
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
		setCanvasSettings(1,  // width of the canvas in tiles
                1,  // height of the canvas in tiles
                myTileWidth,  // width of one tile
                myTileHeight,  // height of one tile
                null,// foreground colour -> use default colour white
                JGColor.blue,// background colour -> use default colour black
                null); // standard font -> use default font);
	}
	
	public void initGame() {
		setFrameRate(35, 1);
		
		//defineAllImages();
	}
	
	public void doFrame() {
		myGameManager.manageTurns();
	}
	
	public void nextPlayer() {
		
	}
	
	public Player getCurrentPlayer() {
		return myCurrentPlayer;
	}
	
	public ArrayList<Player> getPlayers() {
		return myPlayers;
	}
	
	public void loadMap(GameMap map) {
	    myGameMap = map;
	}
	
	public void loadUnit(ArrayList<Unit> units) {
		myUnits = units;
	}
	
	public void loadPlayer(ArrayList<Player> players) {
	    myPlayers = players;
	}
}
