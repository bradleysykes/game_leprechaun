package gae.panel_lists;

import java.io.File;
import java.util.List;

import gae.Constants;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.TileViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.stats.Stat;
import model.tile.Tile;

public class TileList extends BoardList {
	
	public TileList(Controller controller){
		super(controller);
		myDefaultModel = DEFAULT_TILE_STATS;
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
		return new TilePopupMenu(myController, this);
	}
	
	public void postInput(List<Stat> inputData, String name, File imageFile){
		BoardListViewItem newItem = getNewItem(inputData,name,imageFile);
		this.addNewItem(newItem);
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f) {
		return new TileViewItem(inputData,name,f);
	}

}
