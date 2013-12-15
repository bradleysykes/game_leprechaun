package gae.menu_bar;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gae.Constants;
import gae.control.Controller;

import javax.swing.JMenuBar;

public class EditMenuBar extends JMenuBar implements Constants {
	
	protected Controller myController;
	protected GUIMenu myFileMenu, myGameMenu;
	protected List<GUIMenu> mySubMenus;
	
	public EditMenuBar(Controller controller){
		myController = controller;
		mySubMenus = new ArrayList<GUIMenu>();
		myController.setMenuBar(this);
		myFileMenu = new FileMenu(myController,this);
		this.add(myFileMenu);
		mySubMenus.add(myFileMenu);
		myGameMenu = new GameMenu(myController,this);
		this.add(myGameMenu);
		mySubMenus.add(myGameMenu);
	}
	
	public void activateSaveItem(){
		myFileMenu.enableAll();
		myGameMenu.enableAll();
	}
	
	public List<GUIMenu> getSubMenus(){
		return mySubMenus;
	}
	
	

}
