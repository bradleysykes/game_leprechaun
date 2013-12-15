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

/**
 * Generic abstract Dialogue box to take information out of fields and send it 
 * to the controller to be generated into the appropriate items.
 * @author Will
 * @author Brad
 */
public abstract class InputDialogue extends JFrame {
	
	protected Controller myController;
	protected List<Stat> myProperties;
	protected BoardList myList;
	protected Map<Stat,ViewItemField> myFieldViews; 
	protected String myCurrentName;
	
	/**
	 * Used to create Model StatCollections (i.e. Units, Tiles, Abilities)
	 * @param name
	 * @param props
	 * @param list
	 */
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
	
	/**
	 * Used to set game parameters (i.e. Number of Players, board size)
	 */
	public InputDialogue(){
		//myController = controller;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Used to create Victory Conditions
	 * @param controller
	 */
	public InputDialogue(Controller controller) {
		myController = controller;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
	}

	/**
	 * Implemented in subclass to create and fill the JPanel with the appropriate
	 * information.
	 * @return
	 */
	public abstract JPanel createGutsPanel();
	
	/**
	 * Send information entered by user directly to the Controller. 
	 */
	public abstract void postInput();
	
	/**
	 * Disposes this dialogue
	 */
	public void disposeDialogue() {
		this.dispose();	
	}
	
	/**
	 * Retrieves and returns the information in the fields of the dialogue
	 * @author Will
	 * @author Brad
	 */
	protected class GetDataAction implements ActionListener {
		protected GetDataAction() {}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			postInput();
		}
	}

	/**
	 * Unused method.
	 */
	public void onClose() {
		// do nothing...yet
		
	}
}
