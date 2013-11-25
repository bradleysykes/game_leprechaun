package gae.panel_lists;

import java.io.File;
import java.util.List;

import model.stats.Stat;
import gae.Controller;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;

public class NullBoardList extends BoardList {

	public NullBoardList() {
		super(new Controller());
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPackageName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getListType() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f) {
		// TODO Auto-generated method stub
		return new NullViewItem();
	}

}
