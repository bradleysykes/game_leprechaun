package engine.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.GameEngine;

import model.Ability;

public class AbilityListener implements ActionListener{
	
	private Ability myAbility;
	private GameEngine myEngine;

	public AbilityListener(GameEngine engine, Ability ability) {
		myAbility = ability;
		myEngine = engine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		myEngine.getModel().setAbility(myAbility);
		myEngine.getGameViewer().getActionPanel().getAbilityListArea().setUnit(myAbility.getUnit());
		// ^^ attempt to have buttons removed if no longer available for that turn.
	}

}
