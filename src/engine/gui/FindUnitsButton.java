package engine.gui;

import java.awt.Dimension;

import javax.swing.JButton;

import engine.GameEngine;
import engine.listeners.FindUnitsListener;

public class FindUnitsButton extends JButton {
	
	private static final String myName = "Find Units";
	private static final Dimension mySize = new Dimension(40, 20);
	
	public FindUnitsButton(GameEngine gameEngine) {
		super(myName);
		setMinimumSize(mySize);
		addActionListener(new FindUnitsListener(gameEngine));
		setAlignmentX(0.5f);
	}
	
}
