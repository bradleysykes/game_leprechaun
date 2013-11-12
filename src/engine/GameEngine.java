package engine;

import java.util.ArrayList;
import java.util.Collection;
import jgame.platform.JGEngine;
import model.*;
import model.tile.Tile;
import model.unit.Unit;

public class GameEngine extends JGEngine {
	
	private GameManager myGameManager;
	private final int myViewerWidth = 800;
	private final int myViewerHeight = 600;
	private int myTileWidth;
	private int myTileHeight;
	private ArrayList<Unit> myUnits;
	private ArrayList<Tile> myTiles;
	private ArrayList<Player> myPlayers;
	private Player currentPlayer;
	
	public GameEngine(GameDataObject gameData) {
		initEngineComponent(myViewerWidth, myViewerHeight);
		myGameManager = new GameManager(gameData);
	}
	
	public void initCanvas() {
		
		
		
	}
	
	public void initGame() {
		setFrameRate(35, 1);
		//myGameManager.dfhdhdxj
		defineAllImages();
	}
	
	public void doFrame() {
		myGameManager.manageTurns();
	}
	
	public void manageTurns() {
		if (currentPlayer.getRemainingMoves() == 0) {
			nextPlayer();
		}
	}
	
	

}
