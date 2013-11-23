package gae.viewitems;

import gae.GUIMap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.stats.Stat;

public class NullViewItem extends BoardListViewItem {

	public NullViewItem() {
		super("");
	}

	@Override
	public Icon getListIcon() {
		return new ImageIcon();
	}

	@Override
	public String getListMessage() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public List<Stat> getModel() {
		// TODO Auto-generated method stub
		return new ArrayList<Stat>();
	}

	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		// do nothing

	}

	@Override
	public void clickOnBoard(GUIMap map, double x, double y,
			PlayerViewItem activePlayer) {
		// do nothing

	}

	@Override
	public BoardListViewItem createModel(List<Stat> inputData, String name,
			File imageFile) {
		return new NullViewItem();
	}

}
