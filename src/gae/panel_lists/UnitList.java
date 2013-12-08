package gae.panel_lists;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.GameElements;
import model.Condition;
import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;
import gae.Constants;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.popup_menus.UnitPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ConditionViewItem;
import gae.viewitems.UnitViewItem;

public class UnitList extends BoardList {
		
	public UnitList(Controller controller){
		super(controller);
		// this list will only hold UnitViewItems
		myDefaultModel = DEFAULT_UNIT_STATS;
	}
	
	/**
	 * string representation of what this list holds
	 */
	@Override
	public String getListType() {
		return "Units";
	}
	
	@Override
	public List<Stat> getDefaultStats(){
		Unit unit = new Unit("Jeff",new Player(),new Tile(2,2,new GameMap(2,2)));
		return unit.getStats();
	}
	
	@Override
	public String getPackageName() {
		return Constants.UNIT_PACKAGE_NAME;
	}
	@Override
	public GAEPopupMenu getPopupMenu(){
		return new UnitPopupMenu(myController, this);
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,File f, int counter) {
		return new UnitViewItem(inputData,name,f,counter);
	}

	public GameElements giveStateObjects(GameElements currentState) {
		Object[] list = new Object[myModel.size()];
		myModel.copyInto(list);
		List<Unit> unitList = new ArrayList<Unit>();
		Map<Unit, String> unitImageMap = new HashMap<Unit, String>();
		for (Object o:list) {
			UnitViewItem uvi = (UnitViewItem) o;
			Unit u = (Unit) uvi.getModelObject();
			unitList.add(u);
			unitImageMap.put(u, uvi.getImagePath());
		}
		currentState.setUnitTypes(unitList);
		currentState.setUnitImageMap(unitImageMap);
		return currentState;
	}
	
	@Override
	public List<Unit> getUnitTypes() {
		Object[] list = new Object[myModel.size()];
		myModel.copyInto(list);
		List<Unit> unitList = new ArrayList<Unit>();
		for (Object o:list) {
			UnitViewItem uvi = (UnitViewItem) o;
			Unit u = (Unit) uvi.getModelObject();
			unitList.add(u);
		}
		return unitList;
	}
	
	@Override
	public List<String> getSpawnableTypes(){
		List<String> spawnableTypes = new ArrayList<String>();
		for(int i = 0; i<myModel.getSize();i++){
			UnitViewItem item = (UnitViewItem)myModel.getElementAt(i);
			spawnableTypes.add(item.getModelObject().getID().split("\\|")[0]);
		}
		return spawnableTypes;
	}
	
	@Override
	public void loadData(GameElements elements){
		Map<Unit,String> unitImageMap = elements.getUnitImageMap();
		if(unitImageMap!=null){
			int i = 0;
			for(Unit unit:unitImageMap.keySet()){
				File unitImageFile = new File(unitImageMap.get(unit));
				this.addNewItem(new UnitViewItem(unit.getStats(),unit.getID().split("\\|")[0],unitImageFile,i));
				i++;
			}
		}
	}
	
}
