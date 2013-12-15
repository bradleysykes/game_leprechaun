package gae.panels;

import gae.Constants;
import gae.control.Controller;
import gae.panel_lists.BoardList;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.TaskViewItem;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.GameElements;
import model.GameMap;
import model.Player;
import model.Resource;
import model.stats.Stat;
import model.unit.Unit;

/**
 * Abstract Superclass, All panels in the GAE extend this class to enable the 
 * Controller to call each method without breaking.  Override or add new methods
 * to expand functionality
 * @author Will
 * @author Brad
 */
public abstract class EditPanel extends JPanel implements Constants {
	
	protected Controller myController;

	/**
	 * Initializes the EditPanel with the given Controller.
	 * @param controller
	 */
	public EditPanel(Controller controller){
		this.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel();
		titleLabel.setText("<html><h3>"+this.getTitle()+"</h3>");
		this.add(titleLabel,BorderLayout.PAGE_START);
		controller.addPanel(this);
		myController = controller;
	}
	
	/**
	 * Overridden to Initialize guts component.
	 * @param component
	 */
	public void initialize(Component component){
//		component.setPreferredSize(preferred);
//		this.setMinimumSize(minimum);
//		this.setPreferredSize(preferred);
//		component.setPreferredSize(preferred);
	}
	
	/**
	 * Removes all instances of the given object.  Overridden in MapPanel
	 * @param item
	 */
	public void removeBoardObject(BoardListViewItem item){
		// default is to do nothing
	}
	
	/**
	 * Used to display the title of each panel
	 */
	public abstract String getTitle();
	
	/**
	 * Posts the List of stats to the ObjectPanel
	 * @param properties
	 */
	public void postProperties(List<Stat> properties){
		// do nothing
	}

	/**
	 * Posts numPlayers PlayerViewItems in PlayerPanel
	 * @param numPlayers
	 */
	public void postPlayers(int numPlayers){
		//do nothing
	}
	
	/**
	 * Adds a ViewItem to the given BoardList
	 * @param item
	 */
	public void addViewItem(ViewItem item){
		// do nothing
	}

	/**
	 * Removes the task of the same type as tvi in the TaskPanel
	 * @param tvi
	 */
	public void removeTask(TaskViewItem tvi) {
		// Default is to do nothing
	}

	/**
	 * Creates the map in the MapPanel based on the dimensions given in data
	 * data must be parsable to an int and have a size of 2.
	 * @param data
	 */
	public void createMap(List<String> data) {
		// do nothing
		
	}

	/**
	 * Adds the needed state objects to the given GameElements and returns it.
	 * Returns Null if game is not savable.
	 * @param currentState
	 * @return
	 */
	public GameElements giveStateObjects(GameElements currentState) {
		// TODO Auto-generated method stub
		return currentState;
	}

	/**
	 * Fills the board with the given ViewItem.  Implemented in MapPanel
	 * @param mySource
	 */
	public void fillBoard(ViewItem mySource) {
		// default is to do nothing
		//override where necessary
	}

	/**
	 * Gets the list of players.  Implemented in the PlayerPanel.
	 * @return
	 */
	public List<Player> getPlayers() {
		// default is do nothing
		return null;
	}

	/**
	 * Gets the list of Units possible.  Implemented in BoardPanel.
	 * @return
	 */
	public List<Unit> getUnitTypes() {
		// default is to return null
		return null;
	}

	/**
	 * Returns the GameMap.  Implemented in MapPanel
	 * @return
	 */
	public GameMap getMap() {
		// Default is to return null
		return null;
	}

	/**
	 * Displays the given file.  Implemented in the MapPanel
	 * @param file
	 */
	public void displayFile(File file) {
		// default is to do nothing
	}

	/**
	 * Closes the map.  Implemented in the MapPanel
	 */
	public void closeMap() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Loads the information out of the GameElements object
	 * @param elements
	 */
	public abstract void loadData(GameElements elements);
	
	/**
	 * Method to properly dispose an EditPanel when the program is terminated. 
	 */
	public void close() {
		//do nothing
	}

	/**
	 * Adds a resource to a player.  Implemented in PlayerPanel
	 * @param resource
	 */
	public void addResource(Resource resource) {
		// do nothing		
	}
}
	

	