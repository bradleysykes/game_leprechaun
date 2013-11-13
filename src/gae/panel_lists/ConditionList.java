package gae.panel_lists;

import gae.Constants;
import gae.viewitems.ConditionViewItem;

public class ConditionList extends BoardList {
	
	public ConditionList(){
		super();
		this.addNewItem(new ConditionViewItem());
	}
	@Override
	public String getListType() {
		// TODO Auto-generated method stub
		return "Conditions";
	}

	@Override
	public String getPackageName() {
		// TODO Auto-generated method stub
		return Constants.CONDITION_PACKAGE_NAME;
	}

}