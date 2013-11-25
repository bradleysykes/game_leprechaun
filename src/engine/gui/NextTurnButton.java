package engine.gui;

import java.awt.Dimension;

import javax.swing.JButton;

import engine.GameEngine;
import engine.listeners.NextTurnListener;

public class NextTurnButton extends JButton {
	
	private static final String myName = "Next Turn";
	private static final Dimension mySize = new Dimension(40, 20);	
	public NextTurnButton(GameEngine ge) {
		super(myName);
		setPreferredSize(mySize);
		addActionListener(new NextTurnListener(ge.getModel()));
		this.setAlignmentX(0.5f);
	}
	
}
