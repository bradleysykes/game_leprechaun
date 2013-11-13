package gae.viewitems;

import gae.Constants;

import javax.swing.Icon;

public abstract class ViewItem implements Constants {

	public abstract Icon getListIcon();
	
	public abstract String getListMessage();

	public void onClick() {
		// TODO Auto-generated method stub
		
	}
}
