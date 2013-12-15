package gae.panel_lists;
import gae.Constants;
import gae.Controller;
import gae.EditTabbedView;
import gae.dialogues.EditDialogue;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;
import gae.listeners.BoardListSelectionListener;
import gae.listeners.PopupListener;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.GameElements;
import model.Resource;
import model.stats.Stat;
import model.unit.Unit;

import java.util.List;

/**
 * Manages a list of BoardListViewItems via a DefaultListModel, is extended to
 * implement specific management techniques
 * @author Will
 * @author Brad
 */
public abstract class BoardList extends JList implements Constants{
		
	protected DefaultListModel myModel;
	protected Controller myController;
	protected Class myType;
	protected GAEPopupMenu myPopup;
	protected List<Stat> myDefaultModel;
	private int myCounter;
	protected EditTabbedView myTabbedView;

	/**
	 * Initializes the BoardList with the given controller
	 * @param controller
	 */
	public BoardList(Controller controller){
		myController = controller;
		myModel = new DefaultListModel();
		this.setModel(myModel);
		this.setBackground(Color.black);
		this.setForeground(Color.red);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.addListSelectionListener(new BoardListSelectionListener());
		this.setCellRenderer(new EditListRenderer());
		myPopup = this.getPopupMenu();
		this.addMouseListener(new PopupListener(myPopup, this));
		myCounter = 0;
		//FOR DEBUG
//		BoardListItem tu = new ToyUnit();
//		this.addNewItem(tu);
	}
	
	/**
	 * Adds the given ViewItem to the BoardList
	 * @param item
	 */
	public void addNewItem(ViewItem item){
		myModel.insertElementAt(item, 0);
		item.setListSource(this);
	}
	
	/**
	 * Returns the controller stored
	 * @return
	 */
	public Controller getController(){
		return myController;
	}
	
	/**
	 * Returns a new GAEPopupMenu.  Override to return the correct kind of popup
	 * filled with appropriate information
	 * @return
	 */
	public GAEPopupMenu getPopupMenu(){
		return new TilePopupMenu(myController, this);
	}
	
	/**
	 * Removes the item in the BoardList at the given index
	 * @param index
	 */
	public void removeItem(int index) {
		myModel.removeElementAt(index);
	}
	
	/**
	 * Sends the list of stats to the controller to be sent to the ObjectsPanel
	 * @param properties
	 */
	public void sendData(List<Stat> properties){
		myController.postProperties(properties);
	}
	
	/**
	 * Returns the package name of the Model object, deprecated
	 * @return
	 */
	@Deprecated
	public abstract String getPackageName();
	
	/**
	 * Returns a string with the type of the BoardList given
	 * @return
	 */
	public abstract String getListType();
	
	/**
	 * Renders the List with the correct label and icon
	 * @author Brad
	 *
	 */
	public class EditListRenderer extends DefaultListCellRenderer{
		
		@Override
		public Component getListCellRendererComponent(JList list, Object item, 
				int index,boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list,item, 
					index,isSelected,cellHasFocus);
			ViewItem display = (ViewItem) item;
			label.setIcon(display.getListIcon());
			label.setText(display.getListMessage());
			return this;
		}
		
	}
	
	/**
	 * called when create button clicked in list toolbar. 
	 * Used to launch input dialogue.
	 */
	public void createCustomType() {
		// create new dialogue, populate with model for this viewitem type
		UnitCreationDialogue d = new UnitCreationDialogue(this.getDefaultName(),getDefaultStats(),this);
	}
	
	/**
	 * Returns the stats for the model object.  If not overridden returns an empty
	 * list. Override to give the correct stats for the type of Model object
	 * @return
	 */
	public List<Stat> getDefaultStats(){
		return new ArrayList<Stat>();
	}
	
	/**
	 * Returns the default name of the given type.  Override to change specific 
	 * type
	 * @return
	 */
	public String getDefaultName(){
		return "";
		
	}
	
	/**
	 * called by inputdialogue's create button action listener. 
	 * Ships data for creation of a new custom type. File is the image path
	 * @param inputData
	 * @param name
	 * @param f
	 */
	public void postNewInput(List<Stat> inputData, String name, File f){
		BoardListViewItem newItem = getNewItem(inputData, name,f, myCounter);
		myCounter++;
		this.addNewItem(newItem);
	}

	/**
	 * called by editdialogue's create button
	 * Creates a new custom type and removes the old one that was edited
	 * File is the image path
	 * @param inputData
	 * @param name
	 * @param f
	 */
	public void postEditInput(List<Stat> inputData, String name, File f){
		BoardListViewItem newItem = getNewItem(inputData, name,f, myCounter);
		int oldLocation = this.getSelectedIndex();
		myModel.removeElementAt(oldLocation);
		this.addNewItem(newItem);
	}
	
	/**
	 * Returns a new BoardListViewItem created from the given inputs.
	 * @param inputData
	 * @param name
	 * @param f
	 * @param counter
	 * @return
	 */
	protected abstract BoardListViewItem getNewItem(List<Stat> inputData, String name,File f, int counter);

	/**
	 * Edits the given GameElements object and returns it.
	 * Overridden by subclasses to give image paths.
	 * @param currentState
	 * @return
	 */
	public GameElements giveStateObjects(GameElements currentState) {
		return currentState;
	}

	/**
	 * Gets all of the types of Units in the current game.  Returns null except
	 * in the UnitList
	 * @return
	 */
	public List<Unit> getUnitTypes() {
		// Default is return null
		return null;
	}

	/**
	 * Method for list to display data loaded from previous saved project. 
	 * Override in subclass if list must update with loaded data. 
	 * @author Bradley
	 * @param GameElements elements: Object encapsulating the data associated with an existing project. 
	 */
	public void loadData(GameElements elements){
		// do nothing in superclass. Override if necessary. 
	}

	/**
	 * Sets the EditTabbedView to:
	 * @param editTabbedView
	 */
	public void setTabbedView(EditTabbedView editTabbedView) {
		myTabbedView = editTabbedView;
	}

	/**
	 * Return a list of all custom units made by the user. Default is to do nothing by
	 * returning an empty collection. 
	 */
	public List<String> getSpawnableTypes() {
		return new ArrayList<String>();
	}

	/**
	 * Returns a list of all possible resources.
	 * @return
	 */
	public List<Resource> getUserResources() {
		return myTabbedView.getUserResources();
	}

		
}
