package gae.panels;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TaskPanel extends EditPanel {
	
	public TaskPanel(){
		super();
		JLabel label = new JLabel();
		label.add(new JButton("Set Map Size"));
		this.add(label, BorderLayout.CENTER);
	}
}