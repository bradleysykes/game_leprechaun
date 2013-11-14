package gae.panels;


import gae.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.things.Thing;

public class TaskPanel extends EditPanel {
	
	public TaskPanel(Controller controller){
		super(controller);
		JLabel label = new JLabel();
		label.add(new JButton("Set Map Size"));
		this.add(label, BorderLayout.CENTER);
	}

	@Override
	public void postProperties(List<Thing> properties) {
		// TODO Auto-generated method stub
		
	}
}
