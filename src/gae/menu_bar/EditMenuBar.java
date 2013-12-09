package gae.menu_bar;

import gae.Constants;
import gae.Controller;

import javax.swing.JMenuBar;

public class EditMenuBar extends JMenuBar implements Constants {
	
	protected Controller myController;
	protected GUIMenu myFileMenu, myGameMenu;
	
	public EditMenuBar(Controller controller){
		myController = controller;
		myController.setMenuBar(this);
		myFileMenu = new FileMenu(myController,this);
		this.add(myFileMenu);
		myGameMenu = new GameMenu(myController,this);
		this.add(myGameMenu);
	}
	
	public void activateSaveItem(){
		myFileMenu.enableAll();
		myGameMenu.enableAll();
	}

}
