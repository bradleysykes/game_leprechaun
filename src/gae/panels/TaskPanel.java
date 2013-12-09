package gae.panels;


import gae.Controller;
import gae.panel_lists.BoardList;
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

import data.GameElements;
import model.Player;

public class TaskPanel extends EditPanel {
	
	private TaskList myList;

	public TaskPanel(Controller controller){
		super(controller);
		myList = new TaskList(controller);
		this.add(myList);
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
	
	@Override
	public GameElements giveStateObjects(GameElements currentState){
		if (myList.getModel().getSize()==0) {
			return currentState;
		}
		return null;
	}

	@Override
	public String getTitle() {
		return TASK_PANEL_TITLE;
	}

	@Override
	public void loadData(GameElements elements) {
		myList.loadData(elements);
	}
	
	@Override
	public void fillBoard(ViewItem mySource){
		myList.removeFillTask();
	}
}
