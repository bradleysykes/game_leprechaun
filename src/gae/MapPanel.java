package gae;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MapPanel extends EditPanel {
	
	public MapPanel(){
		JTextArea textArea = new JTextArea("MAP");
		this.add(textArea);
		this.setBackground(Color.RED);
		initialize(textArea);
	}
}
