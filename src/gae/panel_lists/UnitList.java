package gae.panel_lists;

import gae.Constants;
import gae.viewitems.UnitViewItem;

public class UnitList extends BoardList {
	
	
	public UnitList(){
		super();
		this.addNewItem(new UnitViewItem());
	}
	@Override
	public String getListType() {
		// TODO Auto-generated method stub
		return "Unit";
	}
	@Override
	public String getPackageName() {
		// TODO Auto-generated method stub
		return Constants.UNIT_PACKAGE_NAME;
	}

}
