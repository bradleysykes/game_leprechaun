package engine.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.DataPrimer;
import engine.GameEngine;

public class LoadGameListener implements ActionListener {
	
	private GameEngine myGameEngine;
	
	public LoadGameListener(GameEngine gameEngine) {
		myGameEngine = gameEngine;
	}

	public void actionPerformed(ActionEvent e) {
		
		new DataPrimer(myGameEngine);
		
	}

}
