package gae.panels;


import gae.Controller;
import gae.panel_lists.TaskList;
import gae.viewitems.TaskViewItem;
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
	public void postPlayers(int numPlayers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addViewItem(ViewItem item) {
		myList.addNewItem(item);
	}
	
	@Override
	public void removeTask(TaskViewItem tvi) {	
		for (int n=0; n<myList.getModel().getSize(); n++) {
			if(tvi.getClass().equals(myList.getModel().getElementAt(n).getClass())) {
				myList.removeItem(n);
			}
		}
	}
}
