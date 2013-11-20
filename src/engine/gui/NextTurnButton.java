package engine.gui;

import java.awt.Dimension;

import javax.swing.JButton;

import engine.listeners.NextTurnListener;

public class NextTurnButton extends JButton {
	
	private static final String myName = "Next Turn";
	private static final Dimension mySize = new Dimension(50, 30);	
	public NextTurnButton() {
		super(myName);
		setPreferredSize(mySize);
		addActionListener(new NextTurnListener());
		this.setAlignmentX(0.5f);
	}
	
}
