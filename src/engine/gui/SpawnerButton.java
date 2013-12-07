package engine.gui;

import java.awt.Dimension;

import javax.swing.JButton;

import engine.listeners.SpawnerListener;

public class SpawnerButton extends JButton {
	
	private static final String myName = "Spawn!";
	private final Dimension mySize = new Dimension(40, 20);
	
	public SpawnerButton(SpawnerListener spawnerListener) {
		super(myName);
		addActionListener(spawnerListener);
		setPreferredSize(mySize);
	}
}
