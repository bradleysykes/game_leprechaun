package gae.viewitems;

import gae.Controller;
import gae.GUIMap;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jgame.JGObject;

import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {

	private static final String UNIT_LIST_MESSAGE = "Unit List Message";
	private Unit myUnit = new Unit("TEST",new Player(),new GameMap(400, 400));
	private MapObject myMapObject;
	
	public UnitViewItem(){
		super();
		myProperties = myUnit.getStats();
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
	public void createModel(List<Stat> stats) {
		myUnit.setStats(stats);
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
