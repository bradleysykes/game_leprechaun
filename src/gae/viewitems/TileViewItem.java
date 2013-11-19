package gae.viewitems;

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
	
	public TileViewItem(){
		super();
		myProperties = myTile.getStats();
	}
	
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public void createModel(List<Stat> inputData) {
		myTile.setStats(inputData);
	}

	@Override
	public String getListMessage() {
		return "Tile List Message";
	}
	
	public String getImagePath(){
		return "resources/test_tile.png";
	}

	/**
	 * icon used to display viewitem in its list
	 */
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}

	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		// TODO Auto-generated method stub
		
	}
	
}
