package gae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.tile.Tile;

import util.reflection.Reflection;



public class MapPanel extends EditPanel {
	
	private MapView myMapView;
	private PackageClassFinder myFinder;

	public MapPanel(Observer observer){
		super(observer);
		myFinder = new PackageClassFinder();
		this.setLayout(new BorderLayout());
		this.initialize();
	}
	
	public void setDefaultTiles(){
		try {
			List<Class> classes = myFinder.getClassesForPackage(Constants.TILE_PACKAGE_NAME);
			
			myMapView.setDefaultTiles();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initialize(){
		myMapView = new MapView();
		this.add(myMapView, BorderLayout.CENTER);
		this.setDefaultTiles();
	}

	@Override
	public void execute(Object o) {
		
	}

}
