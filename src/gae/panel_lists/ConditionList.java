package gae.panel_lists;

import gae.Constants;
import gae.Controller;
import gae.dialogues.ConditionDialogue;
import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.ConditionViewItem;

public class ConditionList extends BoardList {
	
	public ConditionList(Controller controller){
		super(controller);
		//tell the list what type of ViewItem it will hold
		myType = new ConditionViewItem();
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

	@Override
	public void createCustomType(){
		new ConditionDialogue(myController, this);
	}

}
