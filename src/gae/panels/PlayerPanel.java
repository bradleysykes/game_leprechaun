package gae.panels;


import gae.Controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.things.Thing;

public class PlayerPanel extends EditPanel {
	public PlayerPanel(Controller controller){
		super(controller);
		JTextArea textArea = new JTextArea("Players");
		this.setBackground(Color.GREEN);
		this.add(textArea);
		initialize(textArea);
	}

	@Override
	public void postProperties(List<Thing> properties) {
		// TODO Auto-generated method stub
		
	}

}
