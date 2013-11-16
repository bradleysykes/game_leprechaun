package gae.panel_lists;

import gae.Constants;
import gae.Controller;
import gae.viewitems.ConditionViewItem;
import gae.viewitems.NewViewItem;

public class ConditionList extends BoardList {
	
	public ConditionList(Controller controller){
		super(controller);
		this.addNewItem(new NewViewItem());
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
