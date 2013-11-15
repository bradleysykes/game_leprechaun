package gae.panel_lists;

import gae.Constants;
import gae.Controller;
import gae.viewitems.UnitViewItem;

public class UnitList extends BoardList {
	
	public UnitList(Controller controller){
		super(controller);
		this.addNewItem(new UnitViewItem());
	}
	@Override
	public String getListType() {
		return "Unit";
	}
	@Override
	public String getPackageName() {
		return Constants.UNIT_PACKAGE_NAME;
	}

}
