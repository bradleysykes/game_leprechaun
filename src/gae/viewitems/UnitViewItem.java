package gae.viewitems;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.unit.Unit;

public class UnitViewItem extends ViewItem {
	
	public UnitViewItem(){
		super();
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}

	@Override
	public String getListMessage() {
		return "Create new unit";
	}

}
