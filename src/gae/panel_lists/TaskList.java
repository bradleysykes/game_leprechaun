package gae.panel_lists;

import java.awt.Component;

import javax.swing.JPopupMenu;

import gae.Controller;
import gae.listeners.BoardListSelectionListener;
import gae.popup_menus.GAEPopupMenu;
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
