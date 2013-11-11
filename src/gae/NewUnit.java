package gae;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;

public class NewUnit implements BoardListItem {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Add New Item";
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(Constants.ICON_PATH+"plus.gif");
	}
	
	public String getImagePath(){
		return "";
	}

	@Override
	public Class getObjectClass() {
		// TODO Auto-generated method stub
		return this.getClass();
	}

	@Override
	public void onSelected(UnitList list) {
		/**
		 * Prompt designer with view to set initial properties for this new Object
		 * type.
		 */
		list.addNewItem(new ToyUnit());
		
	}
	
	
}
