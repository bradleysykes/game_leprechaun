package gae.viewitems;

import java.util.ArrayList;
import java.util.List;

import gae.Constants;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.things.Thing;
import model.tile.Tile;

public class TileViewItem extends BoardListViewItem {

	
	public TileViewItem(){
		
	}
	
	@Override
	public List<Thing> getModel() {
		return new ArrayList<Thing>();
	}
	
}
