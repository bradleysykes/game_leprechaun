package gae.menu_bar;

import gae.Controller;

public class GameMenu extends GUIMenu {
	
	private GUIMenuItem myRunItem;

	public GameMenu(Controller controller, EditMenuBar menuSource) {
		super("Game", controller, menuSource);
		myRunItem = new RunMenuItem(myController,myMenuSource);
		myRunItem.setEnabled(false);
		this.add(myRunItem);
	}

	@Override
	public void enableAll() {
		myRunItem.setEnabled(true);
	}

}
