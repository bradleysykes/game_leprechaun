package gae.panels;


import gae.Controller;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PlayerPanel extends EditPanel {
	public PlayerPanel(Controller controller){
		super(controller);
		JTextArea textArea = new JTextArea("Players");
		this.setBackground(Color.GREEN);
		this.add(textArea);
		initialize(textArea);
	}

}
