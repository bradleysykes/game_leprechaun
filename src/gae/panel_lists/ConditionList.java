package gae.panel_lists;

import java.io.File;
import java.util.List;

import model.Condition;
import model.stats.Stat;
import gae.Constants;
import gae.Controller;
import gae.dialogues.ConditionDialogue;
import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ConditionViewItem;
import gae.viewitems.NullViewItem;

public class ConditionList extends BoardList {
	
	public ConditionList(Controller controller){
		super(controller);
		//tell the list what type of ViewItem it will hold
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

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f) {
		// TODO Auto-generated method stub
		return new NullViewItem();
	}

}
