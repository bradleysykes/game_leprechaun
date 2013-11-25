package gae.panel_lists;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gae.Constants;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.viewitems.TileViewItem;
import gae.viewitems.UnitViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import data.GameElements;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

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
		return new TilePopupMenu(myController, this);
	}
	
	public void postInput(List<Stat> inputData, String name, File f){
		myType = new TileViewItem(inputData,name,f);
		this.addNewItem(myType);
	}

	@Override
	public GameElements giveStateObjects(GameElements currentState) {
		Object[] list = new Object[myModel.size()];
		myModel.copyInto(list);
		List<Tile> tileList = new ArrayList<Tile>();
		Map<String, String> tileImageMap = new HashMap<String, String>();
		for (Object o:list) {
			TileViewItem tvi = (TileViewItem) o;
			Tile t = (Tile) tvi.getModelObject();
			tileList.add(t);
			tileImageMap.put(t.getID(), tvi.getImagePath());
		}
		currentState.setTileImageMap(tileImageMap);
		return currentState;
	}
}
