package gae.panels;

import gae.Constants;
import gae.Controller;
import gae.GUIMap;
import gae.PackageClassFinder;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Player;

import model.tile.Tile;

import util.reflection.Reflection;



public class MapPanel extends EditPanel {
	
	private GUIMap myMapView;
	private PackageClassFinder myFinder;

	public MapPanel(Controller controller){
		super(controller);
		myFinder = new PackageClassFinder();
		this.setLayout(new BorderLayout());
		
	}
	@Override
	public void createMap(List<String> dimensions){
		int width = Integer.parseInt(dimensions.get(0));
		int height = Integer.parseInt(dimensions.get(1));
		myMapView = new GUIMap(width, height);
		this.add(myMapView, BorderLayout.CENTER);
		this.setDefaultTiles();
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


}
