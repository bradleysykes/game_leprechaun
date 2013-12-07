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
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

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
import model.stats.Stat;
import model.unit.Unit;

import java.util.List;

public abstract class BoardList extends JList implements Constants{
		
	protected DefaultListModel myModel;
	protected Controller myController;
	protected Class myType;
	protected GAEPopupMenu myPopup;
	protected List<Stat> myDefaultModel;
	private int myCounter;
	protected EditTabbedView myTabbedView;

	
	public BoardList(Controller controller){
		myController = controller;
		myModel = new DefaultListModel();
		this.setModel(myModel);
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
	

	public void addNewItem(ViewItem item){
		myModel.insertElementAt(item, 0);
	}
	public Controller getController(){
		return myController;
	}
	
	public GAEPopupMenu getPopupMenu(){
		return new TilePopupMenu(myController, this);
	}
	
	public void removeItem(int index) {
		myModel.removeElementAt(index);
	}
	
	public void sendData(List<Stat> properties){
		myController.postProperties(properties);
	}
	
	public abstract String getPackageName();
	
	public abstract String getListType();
	
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
		UnitCreationDialogue d = new UnitCreationDialogue("Create me!",getDefaultStats(),this);
	}
	
	public List<Stat> getDefaultStats(){
		return new ArrayList<Stat>();
	}
	
	/**
	 * called by inputdialogue's create button action listener. 
	 * Ships data for creation of a new custom type. 
	 * @param inputData
	 * @param name 
	 */
	public void postNewInput(List<Stat> inputData, String name, File f){
		BoardListViewItem newItem = getNewItem(inputData, name,f, myCounter);
		myCounter++;
		this.addNewItem(newItem);
	}
	
	public void postEditInput(List<Stat> inputData, String name, File f){
		BoardListViewItem newItem = getNewItem(inputData, name,f, myCounter);
	}
	
	protected abstract BoardListViewItem getNewItem(List<Stat> inputData, String name,File f, int counter);


	public GameElements giveStateObjects(GameElements currentState) {
		return currentState;
	}


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


	public void setTabbedView(EditTabbedView editTabbedView) {
		myTabbedView = editTabbedView;
	}

		
}
