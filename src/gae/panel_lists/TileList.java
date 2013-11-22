package gae.panel_lists;

import gae.Constants;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.viewitems.TileViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.tile.Tile;

public class TileList extends BoardList {
	
	public TileList(Controller controller){
		super(controller);
		myType = new TileViewItem();
	}
	
	@Override
	public String getListType() {
		return "Tiles";
	}
	@Override
	public String getPackageName() {
		return Constants.TILE_PACKAGE_NAME;
	}

	@Override
	public GAEPopupMenu getPopupMenu() {
		// TODO Auto-generated method stub
		return new TilePopupMenu(myController);
	}

}
