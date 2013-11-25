package gae.panel_lists;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.GameElements;
import model.Condition;
import model.stats.Stat;
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
		return "Unit";
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
		Map<String, String> unitImageMap = new HashMap<String, String>();
		for (Object o:list) {
			UnitViewItem uvi = (UnitViewItem) o;
			Unit u = (Unit) uvi.getModelObject();
			unitList.add(u);
			unitImageMap.put(u.getID(), uvi.getImagePath());
		}
		currentState.setUnitTypes(unitList);
		currentState.setUnitImageMap(unitImageMap);
		return currentState;
	}
	
}
