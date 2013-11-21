package gae.popup_menus;

import javax.swing.JPopupMenu;

public abstract class GAEPopupMenu extends JPopupMenu {
	
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
}
