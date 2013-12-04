package engine;

import java.util.*;

import javax.swing.JFrame;

import model.Player;
import jgame.platform.JGEngine;

public class GameManager {

	private GameEngine myGameEngine;
	private List<Player> myPlayers;
	private Player myCurrentPlayer;
	
	public GameManager(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myPlayers = myGameEngine.getPlayers();
		myCurrentPlayer = myPlayers.get(0);
		
	}
	
	public void manageTurns() {
//		if (myGameEngine.getCurrentPlayer()) {
//			nextPlayer();
//		}
	}
			
	public Player nextPlayer() {
		int index = myPlayers.indexOf(myCurrentPlayer);
		int allPlayers = myPlayers.size();
		if (index==allPlayers-1) myCurrentPlayer = myPlayers.get(0);
		else myCurrentPlayer = myPlayers.get(0+1);
		return myCurrentPlayer;
	}
	
	public Player getCurrentPlayer() {
		return myCurrentPlayer;
	}
	
}
