package gae.panel_lists;

import gae.Constants;
import gae.Controller;
import gae.viewitems.NewViewItem;
import gae.viewitems.TileViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.tile.Tile;

public class TileList extends BoardList {

	public TileList(Controller controller){
		super(controller);
		this.addNewItem(new NewViewItem());
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
