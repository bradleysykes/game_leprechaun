package gae.panel_lists;
import gae.Controller;
import gae.dialogues.UnitCreationDialogue;
import gae.listeners.BoardListSelectionListener;
import gae.listeners.PopupListener;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import model.things.Stat;

import java.util.List;

public abstract class BoardList extends JList {
		
	private DefaultListModel myModel;
	protected Controller myController;
	protected BoardListViewItem myType;
	
	public BoardList(Controller controller){
		myController = controller;
		myModel = new DefaultListModel();
		this.setModel(myModel);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.addListSelectionListener(new BoardListSelectionListener());
		this.setCellRenderer(new EditListRenderer());
		//this.addNewItem(new NewUnit(getListType()));
		this.addMouseListener(new PopupListener());
		//FOR DEBUG
//		BoardListItem tu = new ToyUnit();
//		this.addNewItem(tu);
	}
	

	public void addNewItem(ViewItem item){
		item.setController(myController);
		myModel.insertElementAt(item, 0);
	}
	public Controller getController(){
		return myController;
	}
	
	public void removeItem(int index) {
		myModel.remove(index);
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
	
	public class DeleteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	/**
	 * called when create button clicked in list toolbar. 
	 * Used to launch input dialogue.
	 */
	public void createCustomType() {
		// create new dialogue, populate with model for this viewitem type
		UnitCreationDialogue d = new UnitCreationDialogue(myType.getListMessage(),myType.getModel(),this);
		// on close, dialogue sends it to postInput method
	}
	
	/**
	 * called by inputdialogue's create button action listener. 
	 * Ships data for creation of a new custom type. 
	 * @param inputData
	 */
	public void postInput(List<Stat> inputData){
		myType.createModel(inputData);
		this.addNewItem(myType);
	}
		
}
