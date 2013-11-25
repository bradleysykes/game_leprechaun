package gae.panel_lists;

import java.io.File;
import java.util.List;

import model.stats.Stat;
import gae.Constants;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.popup_menus.UnitPopupMenu;
import gae.viewitems.BoardListViewItem;
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
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f) {
		return new UnitViewItem(inputData,name,f);
	}

	
	
}
