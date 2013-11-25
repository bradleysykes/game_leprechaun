package gae.panel_lists;

import java.io.File;
import java.util.List;

import model.stats.Stat;
import gae.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.PlayerPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
import gae.viewitems.ViewItem;

public class PlayerList extends BoardList {
	
	public PlayerList(Controller controller) {
		super(controller);
	}

	@Override
	public String getPackageName() {
		return "";
	}
	
	@Override
	public GAEPopupMenu getPopupMenu(){
		return new PlayerPopupMenu(myController,this);
	}

	@Override
	public String getListType() {
		return "";
	}
	@Override
	public void addNewItem(ViewItem item){
		myModel.insertElementAt(item, myModel.size());
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f, int counter) {
		return new NullViewItem();
	}
}
