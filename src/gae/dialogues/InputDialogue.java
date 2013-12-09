package gae.dialogues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gae.Controller;
import gae.ViewItemField;
import gae.listeners.GAEWindowListener;
import gae.panel_lists.BoardList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.stats.Stat;

public abstract class InputDialogue extends JFrame {
	
	protected Controller myController;
	protected List<Stat> myProperties;
	protected BoardList myList;
	protected Map<Stat,ViewItemField> myFieldViews; 
	protected String myCurrentName;
	
	public InputDialogue(String name, List<Stat> props, BoardList list){
		super();
		myProperties = props;
		myFieldViews = new HashMap<Stat,ViewItemField>();
		myList = list;
		myCurrentName = name;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.addWindowListener(new GAEWindowListener(this));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public InputDialogue(){
		//myController = controller;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public InputDialogue(Controller controller) {
		myController = controller;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
	}

	public abstract JPanel createGutsPanel();
	
	/**
	 * Send information entered by user directly to the Controller. 
	 */
	public abstract void postInput();
	
	public void disposeDialogue() {
		this.dispose();	
	}
	
	protected class GetDataAction implements ActionListener {
		protected GetDataAction() {}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			postInput();
		}
	}

	public void onClose() {
		// do nothing...yet
		
	}
}
