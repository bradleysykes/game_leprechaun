package gae;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MapPanel extends EditPanel {
	
	public MapPanel(){
		super();
		this.add(new MapView());
		initialize();
	}
	
	public void initialize(){
		this.setPreferredSize(new Dimension(600,600));
		
	}
}
