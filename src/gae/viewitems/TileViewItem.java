package gae.viewitems;

import gae.Constants;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.tile.Tile;

public class TileViewItem extends ViewItem {

	
	public TileViewItem(){
		
	}
	@Override
	
	public Icon getListIcon(){
		return new ImageIcon(Constants.ICON_PATH+"plus.gif");
	}
	
	@Override
	public String getListMessage(){
		return "Click to create new Tile";
	}
	
}
