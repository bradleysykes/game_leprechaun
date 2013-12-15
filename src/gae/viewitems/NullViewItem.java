package gae.viewitems;

import gae.map.GUIMap;

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
	protected int getResizeDimensions() {
		return 0;
	}

	@Override
	protected String getDefaultImagePath() {
		return DEFAULT_UNIT_PATH;
	}

	@Override
	protected String getMapPrefix() {
		return "";
	}

	public Object getModelObject() {
		return new Object();
	}

}
