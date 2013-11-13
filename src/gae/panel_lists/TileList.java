package gae.panel_lists;

import gae.Constants;
import gae.viewitems.TileViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.tile.Tile;

public class TileList extends BoardList {

	public TileList(){
		super();
		this.addNewItem(new TileViewItem());
	}
	
	@Override
	public String getListType() {
		return "Tiles";
	}
	@Override
	public String getPackageName() {
		return Constants.TILE_PACKAGE_NAME;
	}

}
