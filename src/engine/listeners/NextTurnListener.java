package engine.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Attributes;
import model.Model;
import model.Player;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;
import engine.GameEngine;
import engine.GameViewer;
import engine.gui.PlayerStatusArea;
import engine.gui.UnitStatusArea;

public class NextTurnListener implements ActionListener {
	
	Model myModel;
	GameEngine myGameEngine;
	
	public NextTurnListener(Model m, GameEngine ge) {
		myModel = m;
		myGameEngine = ge;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Next turn for model");
		PlayerStatusArea playerStatusArea = (PlayerStatusArea) GameViewer.getFeedbackPanel().getPlayerStatusArea();
		Player currentPlayer = myGameEngine.getGameManager().getCurrentPlayer();
		setPlayerStatusArea(currentPlayer, playerStatusArea);
		
		
		//myModel.nextTurn();
	}
	
	private void setPlayerStatusArea(Player player, PlayerStatusArea playerStatusArea) {
		
		List<Stat> myResources = player.getStatCollection("Resources").getStats();
		String statusReport = "";
		for (Stat stat : myResources) {
			String resourceName = stat.getName();
			String resourceValue = stat.getField();
			statusReport += resourceName + ":" + " " + resourceValue + "\n";
		}
		playerStatusArea.setStatusText(statusReport);
	}
	
}
