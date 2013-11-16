package gae.viewitems;


import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jgame.JGObject;
import jgame.platform.JGEngine;

import model.GameMap;
import model.Player;
import model.things.Thing;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {
	List<Thing> myProperties = new Unit("TEST",new Player(),new GameMap(400, 400)).getThings();
	
	public UnitViewItem(){
		super();
	}
	
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}

	@Override
	public String getListMessage() {
		return "Create new unit";
	}
	@Override
	public List<Thing> getModel() {
		return myProperties;
	}

}
