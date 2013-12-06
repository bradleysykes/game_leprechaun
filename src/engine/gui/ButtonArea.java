package engine.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import engine.GameEngine;

public class ButtonArea extends JPanel {
	
	private final Dimension mySize = new Dimension(250, 25);
	
	public ButtonArea(GameEngine gameEngine) {
		setPreferredSize(mySize);
		setLayout(new FlowLayout());
		add(new NextTurnButton(gameEngine));
		add(new FindUnitsButton(gameEngine));
	}
	
}
