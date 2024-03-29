package engine.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.Attributes;
import model.Model;
import model.Player;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;
import engine.GameEngine;
import engine.GameViewer;
import engine.gui.AbilityListArea;
import engine.gui.JohnTestAbilityArea;
import engine.gui.StatusArea;
import engine.gui.UnitListArea;

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
		JohnTestAbilityArea abilityArea = (JohnTestAbilityArea) myGameEngine.getGameViewer().getActionPanel().getAbilityListArea();
		UnitListArea unitListArea = (UnitListArea) myGameEngine.getGameViewer().getActionPanel().getUnitListArea();
		abilityArea.clear();
		StatusArea unitStatusArea = myGameEngine.getGameViewer().getFeedbackPanel().getUnitStatusArea();
		unitStatusArea.setStatusText("");
		unitListArea.loadUnitList(new ArrayList<Unit>());
		myGameEngine.removeTileHighlights();
		myGameEngine.removeCurrentPlayerHighlights();
		myGameEngine.getGameManager().nextPlayer();
		myGameEngine.getModel().refresh();
	}
	
	private void setPlayerStatusArea(Player player) {
		
		StatusArea playerStatusArea = GameViewer.getFeedbackPanel().getPlayerStatusArea();
		List<Stat> myResources = player.getStatCollection("Resources").getStats();
		String statusReport = "";
		statusReport += player.getID() + "\n";
		for (Stat stat : myResources) {
			String resourceName = stat.getName();
			String resourceValue = stat.getField();
			statusReport += resourceName + ":" + " " + resourceValue + "\n";
		}
		playerStatusArea.setStatusText(statusReport);
	}
	
}
