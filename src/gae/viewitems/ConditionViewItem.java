package gae.viewitems;


import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConditionViewItem extends ViewItem {

	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}

	@Override
	public String getListMessage() {
		return "Create new victory condition";
	}

}
