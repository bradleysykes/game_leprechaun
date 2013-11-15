package gae.panels;

import gae.Constants;
import gae.Controller;
import gae.viewitems.TaskViewItem;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import model.Player;
import model.things.Thing;


public abstract class EditPanel extends JPanel implements Constants {
	
	private Controller myController;

	public EditPanel(Controller controller){
		this.setLayout(new BorderLayout());
		controller.addPanel(this);
		myController = controller;
	}
	
	public void initialize(Component component){
//		component.setPreferredSize(preferred);
//		this.setMinimumSize(minimum);
//		this.setPreferredSize(preferred);
//		component.setPreferredSize(preferred);
	}
	
	public abstract void postProperties(List<Thing> properties);

	public abstract void postPlayers(int numPlayers);
	
	public abstract void addViewItem(ViewItem item);

	public void removeTask(TaskViewItem tvi) {
		// Default is to do nothing
	}
}
	

	