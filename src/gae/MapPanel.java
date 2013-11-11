package gae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MapPanel extends EditPanel {
	
	private MapView myMapView;

	public MapPanel(){
		super();
		this.setLayout(new BorderLayout());
		myMapView = new MapView();
		this.add(myMapView, BorderLayout.CENTER);
		this.addMouseListener(new MapMouseListener(myMapView));
		initialize();
	}
	
	public void initialize(){
		//this.setPreferredSize(new Dimension(600,600));
		
	}

}
