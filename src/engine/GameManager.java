package engine;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.Player;
import jgame.platform.JGEngine;

public class GameManager {

	private GameEngine myGameEngine;
	
	public GameManager(GameEngine gameEngine) {
		myGameEngine = gameEngine;
	}
	
	public void manageTurns() {
//		if (myGameEngine.getCurrentPlayer()) {
//			nextPlayer();
//		}
	}
			
	public void nextPlayer() {
		ArrayList<Player> playerList = myGameEngine.getPlayers();
		
	}
	
	
}
