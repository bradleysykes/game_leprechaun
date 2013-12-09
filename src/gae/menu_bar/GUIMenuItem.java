package gae.menu_bar;

import java.awt.event.ActionListener;

import gae.Controller;

import javax.swing.JMenuItem;

public abstract class GUIMenuItem extends JMenuItem {
	
	protected Controller myController;
	protected EditMenuBar myMenuSource;
	
	public GUIMenuItem(String name, Controller controller, EditMenuBar menuSource){
		super(name);
		myController = controller;
		myMenuSource = menuSource;
		this.addActionListener(this.getActionListener());
	}
	
	protected abstract ActionListener getActionListener();
	
	
}
