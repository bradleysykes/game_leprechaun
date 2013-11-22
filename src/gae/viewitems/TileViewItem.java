package gae.viewitems;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gae.Constants;
import gae.GUIMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.GameMap;
import model.stats.Stat;
import model.tile.Tile;

public class TileViewItem extends BoardListViewItem {

	private Tile myTile = new Tile(20,20,new GameMap(20,20));
	private MapObject myMapObject;
	private File myImage = new File("resources/test_tile.jpg");
	
	public TileViewItem(){
		super("Test Tile");
		myProperties = myTile.getStats();
	}
	
	public TileViewItem(List<Stat> stats,String name, File f){
		super(name);
		myProperties = stats;
		myImage = f;
	}
	
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public BoardListViewItem createModel(List<Stat> inputData, String name, File imageFile) {
		//newGuy.setStats(inputData);
		BoardListViewItem newGuy = new TileViewItem();
		return newGuy;
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	
	public String getImagePath(){
		if(myImage!=null){
			return myImage.getPath();
		}
		return "resources/test_tile.jpg";
	}

	/**
	 * icon used to display viewitem in its list
	 */
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}
	
	public int getImageHeight(){
		return 0;
	}
	public int getImageWidth(){
		return 0;
	}

	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		map.defineImage("tile", "-", 0,getImagePath().replace("\\","/"),"-");
		//new JGObject(such and such);
		myMapObject = new MapObject(x,y,"tile", this);
	}
	
}
