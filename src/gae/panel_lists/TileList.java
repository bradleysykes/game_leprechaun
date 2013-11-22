package gae.panel_lists;

import java.io.File;
import java.util.List;

import gae.Constants;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.viewitems.TileViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.stats.Stat;
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
	
	public void postInput(List<Stat> inputData, String name, File f){
		myType = new TileViewItem(inputData,name,f);
		this.addNewItem(myType);
	}

}
