package gae.menu_bar;

import gae.Controller;

import javax.swing.JMenu;

public abstract class GUIMenu extends JMenu {
	
	protected Controller myController;
	protected EditMenuBar myMenuSource;
	
	public GUIMenu(String name, Controller controller, EditMenuBar menuSource){
		super(name);
		myController = controller;
		myMenuSource = menuSource;
	}
	
	public abstract void enableAll();

}
