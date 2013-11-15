package gae.panels;


import gae.Controller;
import gae.panel_lists.TaskList;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Player;
import model.things.Thing;

public class TaskPanel extends EditPanel {
	
	private TaskList myList;

	public TaskPanel(Controller controller){
		super(controller);
		myList = new TaskList(controller);
		this.add(myList);
	}

	@Override
	public void postProperties(List<Thing> properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postPlayers(List<Player> myPlayers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addViewItem(ViewItem item) {
		myList.addNewItem(item);
	}
}
