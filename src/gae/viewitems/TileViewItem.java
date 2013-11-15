package gae.viewitems;

import java.util.ArrayList;
import java.util.List;

import gae.Constants;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.things.Thing;
import model.tile.Tile;

public class TileViewItem extends ViewItem {

	
	public TileViewItem(){
		
	}
	@Override
	
	public Icon getListIcon(){
		System.out.println(Constants.ICON_PATH+"plus.gif");
		return new ImageIcon(Constants.ICON_PATH+"plus.gif");
	}
	
	@Override
	public String getListMessage(){
		return "Create new Tile";
	}
	@Override
	public List<Thing> getModel() {
		return new ArrayList<Thing>();
	}
	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}
	
}
