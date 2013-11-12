package engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import jgame.platform.JGEngine;
import model.*;

public class GameEngine extends JGEngine {
	
	private GameManager myGameManager;
	private final int myViewerWidth = 800;
	private final int myViewerHeight = 600;
	private int myTileWidth;
	private int myTileHeight;
	private ArrayList<Unit> myUnits;
	private GameMap myGameMap;
	private ArrayList<Player> myPlayers;
	private Player myCurrentPlayer;
	
	public GameEngine(File xmlDataFile) {
		initEngineComponent(myViewerWidth, myViewerHeight);
		myGameManager = new GameManager(this);
	}
	
	public void initCanvas() {
		
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
