package gae.popup_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gae.BoardBuffer;
import gae.Controller;
import gae.panel_lists.BoardList;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ViewItem;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public abstract class GAEPopupMenu extends JPopupMenu {
	
	protected ViewItem mySource;
	protected Controller myController;
	
	public GAEPopupMenu(Controller controller){
		super();
		myController = controller;
	}

	protected void initialize() {
		//all shared menu items go here
		//then call subclass initialize
		JMenuItem propertiesItem = new JMenuItem("Properties");
		propertiesItem.addActionListener(new PropertiesListener());
		this.add(propertiesItem);
		subInitialize();
	}
	
	public class PropertiesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// launch view of this item's properties
			mySource.showProperties();
		}
		
	}
	
	public abstract void subInitialize();
	
	public void setSource(ViewItem source){
		mySource = source;
	}
	
	public class DeleteListener implements ActionListener {
		private BoardList myList;
		
		public DeleteListener(BoardList list){
			myList = list;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//remove from panel display
			myList.removeItem(myList.getSelectedIndex());
			// clear buffer so it cannot be placed on map
			BoardBuffer.clear();
			myController.removeBoardObject((BoardListViewItem)mySource);
		}
		
	}
	
	public class RemoveListener implements ActionListener {
		public RemoveListener(BoardList list){
			System.out.println("ListenerMade");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ListenerHit");
			myController.removeBoardObject((BoardListViewItem)mySource);
		}
		
	}
}
