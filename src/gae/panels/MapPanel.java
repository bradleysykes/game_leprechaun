package gae.panels;

import gae.Constants;
import gae.Controller;
import gae.GUIMap;
import gae.PackageClassFinder;
import gae.listeners.MapPopupListener;
import gae.popup_menus.MapPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import data.GameElements;
import model.GameMap;
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
		this.setMinimumSize(new Dimension(500,300));
		
	}
	@Override
	public void createMap(List<String> dimensions){
		int width = Integer.parseInt(dimensions.get(0));
		int height = Integer.parseInt(dimensions.get(1));
		myMapView = new GUIMap(width, height, this.getWidth(), this.getHeight());
		myMapView.setPopup(new MapPopupMenu(myController,myMapView));
		this.add(myMapView, BorderLayout.CENTER);
		this.revalidate();
		}
	
	public void removeBoardObject(BoardListViewItem item){
		myMapView.removeObjects(item.getPrefix(),item.getMapObject().colid);
		System.out.println("hah");
	}
	
//	public void setDefaultTiles(){
//		try {
//			List<Class> classes = myFinder.getClassesForPackage(Constants.TILE_PACKAGE_NAME);
//			
//			myMapView.setDefaultTiles();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void fillBoard(ViewItem tile){
		if(myMapView!=null){
			myMapView.fillBoard(tile);
		}
	}
		
	@Override
	public GameElements giveStateObjects(GameElements currentState) {
		currentState.setGameMap(myMapView.getModelMap());
		return currentState;
	}
	public void clearMap() {
		myMapView.removeObjects(null, 0);
	}
	public boolean hasMap() {
		return myMapView!=null;
	}
	
	@Override
	public String getTitle() {
		return MAP_PANEL_TITLE;
	}
}
