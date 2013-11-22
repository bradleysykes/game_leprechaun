package gae.popup_menus;

import gae.viewitems.ViewItem;

import javax.swing.JPopupMenu;

public abstract class GAEPopupMenu extends JPopupMenu {
	
	protected ViewItem mySource;
	
	public GAEPopupMenu(){
		super();
		initialize();
	}

	private void initialize() {
		//all shared menu items go here
		//then call subclass initialize
		subInitialize();
	}
	
	public abstract void subInitialize();
	
	public void setSource(ViewItem source){
		mySource = source;
	}
}
