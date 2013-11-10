package gae;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MapPanel extends EditPanel {
	
	public MapPanel(){
		super();
		JTextArea textArea = new JTextArea("MAP");
		this.add(textArea);
		this.setBackground(Color.RED);
		initialize();
	}
	
	public void initialize(){
		this.setPreferredSize(new Dimension(600,600));
		
	}
}
