package gae.popup_menus;

import gae.Controller;
import gae.viewitems.ViewItem;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public abstract class GAEPopupMenu extends JPopupMenu {
	
	protected ViewItem mySource;
	protected Controller myController;
	
	public GAEPopupMenu(Controller controller){
		super();
		myController = controller;
		initialize();
	}

	private void initialize() {
		//all shared menu items go here
		//then call subclass initialize
		JMenuItem item = new JMenuItem("Properties");
		this.add(item);
		subInitialize();
	}
	
	public abstract void subInitialize();
	
	public void setSource(ViewItem source){
		mySource = source;
	}
}
