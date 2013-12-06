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
import gae.viewitems.BoardListViewItem;
import gae.viewitems.TileViewItem;
import gae.viewitems.UnitViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import data.GameElements;
import model.GameMap;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class TileList extends BoardList {
	
	private int myIDCounter;

	public TileList(Controller controller){
		super(controller);
		myDefaultModel = DEFAULT_TILE_STATS;
	}
	
	@Override
	public String getListType() {
		return "Tiles";
	}
	
	@Override
	public List<Stat> getDefaultStats(){
		Tile tile = new Tile(2,2,new GameMap(2,2));
		return tile.getStats();
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

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,File f,int counter) {
		myIDCounter = counter;
		return new TileViewItem(inputData,name,f,counter);
	}

	@Override
	public GameElements giveStateObjects(GameElements currentState) {
		Object[] list = new Object[myModel.size()];
		myModel.copyInto(list);
		List<Tile> tileList = new ArrayList<Tile>();
		Map<Tile, String> tileImageMap = new HashMap<Tile, String>();
		for (Object o:list) {
			TileViewItem tvi = (TileViewItem) o;
			Tile t = (Tile) tvi.getModelObject();
			tileList.add(t);
			tileImageMap.put(t, tvi.getImagePath());
		}
		currentState.setTileImageMap(tileImageMap);
		return currentState;
	}
	
	@Override
	public void loadData(GameElements elements){
		GameMap loadMap = elements.getGameMap();
		Map<Tile,String> tileImages = elements.getTileImageMap();
		for(Tile tile:tileImages.keySet()){
			File tileImageFile = new File(tileImages.get(tile));
			TileViewItem item = new TileViewItem(tile.getStats(), tile.getID().split("\\|")[0], tileImageFile,0);
			this.addNewItem(item);
		}
	}
}
