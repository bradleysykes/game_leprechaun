package gae.menu_bar;

import java.awt.event.ActionListener;

import gae.Constants;
import gae.control.Controller;

import javax.swing.JMenuItem;

public abstract class GUIMenuItem extends JMenuItem implements Constants {
	
	protected Controller myController;
	protected EditMenuBar myMenuSource;
	protected boolean myExecuted = false;
	
	public GUIMenuItem(String name, Controller controller, EditMenuBar menuSource){
		super(name);
		myController = controller;
		myMenuSource = menuSource;
		this.addActionListener(this.getActionListener());
	}
	
	protected abstract ActionListener getActionListener();
	
	public boolean hasExecuted(){
		return myExecuted;
	}
	
	
}
