package gae.viewitems;

import gae.Controller;

import java.util.List;

import javax.swing.Icon;

import model.GameMap;
import model.Player;
import model.things.Stat;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {
	List<Stat> myProperties = new Unit("TEST",new Player(),new GameMap(400, 400)).getStats();

	@Override
	public List<Stat> getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onClick(Controller c) {
		//create on map

	}

}
