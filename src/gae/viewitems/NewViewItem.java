package gae.viewitems;


import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jgame.JGObject;
import jgame.platform.JGEngine;

import model.GameMap;
import model.Player;
import model.things.Stat;
import model.unit.Unit;

public class NewViewItem extends BoardListViewItem {
	
	public NewViewItem(){
		super();
	}
	
	@Override
	public Icon getListIcon() {
		ImageIcon i = new ImageIcon(ICON_PATH+"plus.gif");
		return i;
	}

	@Override
	public String getListMessage() {
		return "Create new";
	}
	@Override
	public List<Stat> getModel() {
		return new ArrayList<Stat>();
	}

}
