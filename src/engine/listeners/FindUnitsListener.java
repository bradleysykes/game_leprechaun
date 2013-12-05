package engine.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.GameEngine;

public class FindUnitsListener implements ActionListener {
	
	private GameEngine myGameEngine;
	private boolean isActive;
	
	public FindUnitsListener(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		isActive = false;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (isActive) {
			myGameEngine.removeCurrentPlayerHighlights();
			isActive = !isActive;
			return;
		}
		myGameEngine.highlightCurrentPlayer();
		isActive = !isActive;
	}
	
}
