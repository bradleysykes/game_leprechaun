package gae.viewitems;

import gae.Controller;
import gae.GUIMap;

import java.io.File;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jgame.JGObject;

import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {

	private String UNIT_LIST_MESSAGE = "Unit List Message";
	private Unit myUnit;
	private MapObject myMapObject;
	
	public UnitViewItem(List<Stat> stats, String name){
		this(name);
		myProperties = stats;
		myUnit.setStats(myProperties);		
	}
	
	public UnitViewItem(String name) {
		super();
		myUnit = new Unit("TEST",new Player(),new GameMap(400, 400));
		myProperties = myUnit.getStats();
		UNIT_LIST_MESSAGE = name;
	}
	/**
	 * use to figure out what properties this type needs
	 */
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public void onClick(Controller c) {
		//create on map

	}

	@Override
	public BoardListViewItem createModel(List<Stat> stats, String name, 
			File imageFile) {
		BoardListViewItem newGuy = new UnitViewItem(stats, name);
		return newGuy;
	}
	
	public String getImagePath(){
		return "resources/test_icon_image.png";
	}

	@Override
	public String getListMessage() {
		return UNIT_LIST_MESSAGE;
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}
	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		map.defineImage("unit", "-", 0, getImagePath(),"-");
		//new JGObject(such and such);
		MapObject object = new MapObject(x,y,"unit", this);
	}

}
