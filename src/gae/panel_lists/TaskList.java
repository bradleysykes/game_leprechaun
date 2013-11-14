package gae.panel_lists;

import gae.Controller;
import gae.viewitems.TaskViewItem;



public class TaskList extends BoardList {

	public TaskList(Controller controller) {
		super(controller);
		//this.addNewItem(new TaskViewItem());
	}

	@Override
	public String getPackageName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListType() {
		// TODO Auto-generated method stub
		return null;
	}

}
