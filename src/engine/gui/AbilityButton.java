package engine.gui;

import java.awt.Dimension;

import javax.swing.JButton;

import model.Ability;

import engine.GameEngine;
import engine.listeners.AbilityListener;
import engine.listeners.NextTurnListener;

public class AbilityButton extends JButton {
	
	private static final Dimension mySize = new Dimension(20, 20);	
	public AbilityButton(GameEngine ge, Ability ability) {
		super(ability.getName());
		setMinimumSize(mySize);
		this.addActionListener(new AbilityListener(ge, ability));
	}
	
}
