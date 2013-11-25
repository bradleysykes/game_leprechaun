package gae.panel_lists;

import java.awt.Component;
import java.io.File;
import java.util.List;

import javax.swing.JPopupMenu;

import model.stats.Stat;

import gae.Controller;
import gae.listeners.BoardListSelectionListener;
import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
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

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f) {
		return new NullViewItem();
	}


}
