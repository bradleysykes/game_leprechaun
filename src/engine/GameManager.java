package engine;

import java.util.*;

import javax.swing.JFrame;

import engine.gui.AbilityListArea;
import engine.gui.ActionPanel;
import engine.gui.StatusArea;
import model.Player;
import model.Resource;
import model.stats.Stat;
import jgame.platform.JGEngine;

public class GameManager {

	private GameEngine myGameEngine;
	private List<Player> myPlayers;
	private Player myCurrentPlayer;
	
	public GameManager(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myPlayers = myGameEngine.getPlayers();
		myCurrentPlayer = myPlayers.get(0);
		setPlayerStatusArea();
	}
			
	public Player nextPlayer() {
		int index = myPlayers.indexOf(myCurrentPlayer);
		int allPlayers = myPlayers.size();
		if (index==allPlayers-1) myCurrentPlayer = myPlayers.get(0);
		else myCurrentPlayer = myPlayers.get(index+1);
		return myCurrentPlayer;
	}
	
	public void setPlayerStatusArea() {
		
		StatusArea playerStatusArea = GameViewer.getFeedbackPanel().getPlayerStatusArea();
		List<Stat> myResources = myCurrentPlayer.getStatCollection("Resources").getStats();
		String statusReport = "";
		statusReport += myCurrentPlayer.getID() + "\n";
		int numUnits = myCurrentPlayer.getAllUnits().size();
		statusReport += "Number of units: " + numUnits + "\n";
		for (Stat stat : myResources) {
			Resource r = (Resource) stat;
			String resourceName = r.getID().split("\\|")[0];
			double resourceValue = r.getValue("Amount");
			statusReport += resourceName + ":" + " " + resourceValue + "\n";
		}
		playerStatusArea.setStatusText(statusReport);
	}	
	
	public Player getCurrentPlayer() {
		return myCurrentPlayer;
	}
	
}
