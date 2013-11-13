package engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import data.decoder.GameElements;
import jgame.JGColor;
import jgame.platform.JGEngine;
import model.*;
import model.condition.Condition;
import model.tile.Tile;
import model.unit.Unit;

public class GameEngine extends JGEngine {
	
	private GameManager myGameManager;
	private GameLoader myGameLoader;
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
		
		//defineAllImages();
	}
	
	public void doFrame() {
		//checkWinningConditions();
	}
	
//	public void checkWinningConditions() {     //pending implementation of checkVictory()
//		for (Player p : myPlayers) {
//			if(p.checkVictory()) {
//				System.out.println(p.getName() + " wins!");  //just print for testing
//			}
//		}
//				
//	}
	
	public void nextPlayer() {
		
	}
	
	public Player getCurrentPlayer() {
		return myCurrentPlayer;
	}
	
	public ArrayList<Player> getPlayers() {
		return myPlayers;
	}
	
	public void initializeState(GameElements gameElements) {
		myGameLoader = new GameLoader(gameElements);
	}
	
}
