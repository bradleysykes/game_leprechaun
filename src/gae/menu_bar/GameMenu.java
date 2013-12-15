package gae.menu_bar;

import gae.control.Controller;

public class GameMenu extends GUIMenu {
	
	private GUIMenuItem myRunItem;

	public GameMenu(Controller controller, EditMenuBar menuSource) {
		super("Game", controller, menuSource);
		myRunItem = new RunMenuItem(myController,myMenuSource);
		myRunItem.setEnabled(false);
		this.add(myRunItem);
		myItems.add(myRunItem);
	}

	@Override
	public void enableAll() {
		myRunItem.setEnabled(true);
	}
	
	@Override
	public boolean saveActivated(){
		return myRunItem.isEnabled();
	}

}
