package gae.panel_lists;

import java.io.File;
import java.util.List;

import model.stats.Stat;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;

public class PlayerList extends BoardList {
	
	public PlayerList(Controller controller) {
		super(controller);
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
		// TODO Auto-generated method stub
		return new NullViewItem();
	}
}
