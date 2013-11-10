package gae;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TaskPanel extends EditPanel {
	
	public TaskPanel(){
		JTextArea text = new JTextArea("To-do");
		this.add(text);
		this.setBackground(Color.ORANGE);
		initialize(text);
	}
}
