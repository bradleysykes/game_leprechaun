package engine.gui;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Player;

public class PlayerStatusArea extends StatusArea {
	
	public PlayerStatusArea() {
		super();
		add(new Label("PLAYER STATS"));
	}
	
	public void reportPlayerStatus(Player player) {
		
	}
	
}
