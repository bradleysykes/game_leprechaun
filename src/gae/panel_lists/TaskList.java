package gae.panel_lists;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.Timer;

import data.GameElements;

import model.stats.Stat;

import gae.Controller;
import gae.listeners.BoardListSelectionListener;
import gae.listeners.TimerListener;
import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
import gae.viewitems.TaskViewItem;



public class TaskList extends BoardList {
	public TaskList(Controller controller) {
		super(controller);
		//this.addNewItem(new TaskViewItem());
	}

	@Override
	@Deprecated
	public String getPackageName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f, int counter) {
		return new NullViewItem();
	}
	
	@Override
	public void removeItem(int index){
		super.removeItem(index);
		if(myModel.size()==0){
			JOptionPane alertPane = new JOptionPane("You can now save at any time.");
			JDialog alertDialog = alertPane.createDialog(null, "State alert");
			Timer timer = new Timer(2500,new TimerListener(alertDialog));
			timer.setRepeats(false);
			timer.start();
			alertDialog.setVisible(true);
		}
	}
	
	@Override
	public void loadData(GameElements elements){
		myModel.removeAllElements();
	}

	public void removeFillTask() {
		for(int i = 0;i<myModel.getSize();i++){
			TaskViewItem item = (TaskViewItem) myModel.getElementAt(i);
			if(item.getListMessage().equals("Populate the map with tiles")){
				myModel.removeElementAt(i);
			}
		}
	}

}
