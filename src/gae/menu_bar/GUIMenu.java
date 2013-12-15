package gae.menu_bar;

import java.util.ArrayList;
import java.util.List;

import gae.control.Controller;

import javax.swing.JMenu;

public abstract class GUIMenu extends JMenu {
	
	protected Controller myController;
	protected EditMenuBar myMenuSource;
	protected List<GUIMenuItem> myItems;
	
	public GUIMenu(String name, Controller controller, EditMenuBar menuSource){
		super(name);
		myItems = new ArrayList<GUIMenuItem>();
		myController = controller;
		myMenuSource = menuSource;
	}
	
	public abstract void enableAll();
	
	public abstract boolean saveActivated();
	
	public List<GUIMenuItem> getItems(){
		return myItems;
	}

}
