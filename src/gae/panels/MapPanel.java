package gae.panels;

import gae.Constants;
import gae.Controller;
import gae.EditTabbedView;
import gae.GUIMap;
import gae.PackageClassFinder;
import gae.listeners.MapPopupListener;
import gae.popup_menus.MapPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import data.GameElements;
import model.GameMap;
import model.Player;
import model.tile.Tile;
import util.reflection.Reflection;



public class MapPanel extends EditPanel {
	
	private GUIMap myMapView;
	private PackageClassFinder myFinder;
	private JTabbedPane myTabbedView;

	public MapPanel(Controller controller){
		super(controller);
		myFinder = new PackageClassFinder();
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(500,300));
		
	}
	
	private void makeNewMap(List<String> dimensions){
		int mapWidth = Integer.parseInt(dimensions.get(0));
		int mapHeight = Integer.parseInt(dimensions.get(1));
		myMapView = new GUIMap(mapWidth, mapHeight);
	}
	
	private void loadExistingMap(GameElements elements){
		myMapView = new GUIMap(elements);
	}
	
	@Override
	public void close(){
		this.closeMap();
	}
	
	private void setUp(){
		myMapView.setPopup(new MapPopupMenu(myController,myMapView));
		myTabbedView = new JTabbedPane();
		myTabbedView.addTab("Map",myMapView);
		myTabbedView.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)&&myTabbedView.getSelectedIndex()!=0){
					myTabbedView.remove(myTabbedView.getSelectedComponent());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(myTabbedView);
		this.revalidate();
	}
	
	@Override
	public void createMap(List<String> dimensions){
		makeNewMap(dimensions);
		setUp();
	}
	
	public void removeBoardObject(BoardListViewItem item){
		if(item.onMap()){
			myMapView.removeObjects(item.getPrefix(),item.getMapObject().colid);
		}
	}
	
	@Override
	public void closeMap(){
		if(myMapView!=null){
			myMapView.destroy();
			this.revalidate();
		}
	}
	
	@Override
	public void displayFile(File file){
		if(myTabbedView.getTabCount()<2){
			JTextArea fileView = new JTextArea();
			fileView.setBackground(Color.black);
			fileView.setForeground(Color.red);
			fileView.setEditable(false);
			try {
				Scanner in = new Scanner(new FileReader(file.getAbsolutePath()));
				while(in.hasNextLine()){
					fileView.append(in.nextLine()+"\n");
				}
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			JScrollPane scrollPane = new JScrollPane(fileView);
			myTabbedView.addTab("Game File", scrollPane);
		}
		myTabbedView.setSelectedIndex(myTabbedView.getTabCount()-1);
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
	
	@Override
	public GameMap getMap() {
		return myMapView.getModelMap();
	}
	
	@Override
	public void loadData(GameElements elements) {
		this.loadExistingMap(elements);
		setUp();
	}
}
