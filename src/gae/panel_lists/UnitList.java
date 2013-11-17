package gae.panel_lists;

import gae.Constants;
import gae.Controller;
import gae.viewitems.UnitViewItem;

public class UnitList extends BoardList {
	
	public UnitList(Controller controller){
		super(controller);
		// this list will only hold UnitViewItems
		myType = new UnitViewItem();
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
	
}
