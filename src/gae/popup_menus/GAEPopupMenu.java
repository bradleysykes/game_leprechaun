package gae.popup_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gae.Controller;
import gae.panel_lists.BoardList;
import gae.viewitems.ViewItem;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public abstract class GAEPopupMenu extends JPopupMenu {
	
	protected ViewItem mySource;
	protected Controller myController;
	protected BoardList myList;
	
	public GAEPopupMenu(Controller controller, BoardList list){
		super();
		myController = controller;
		myList = list;
		initialize();
	}

	private void initialize() {
		//all shared menu items go here
		//then call subclass initialize
		JMenuItem item = new JMenuItem("Properties");
		this.add(item);
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(new DeleteListener());
		this.add(delete);
		subInitialize();
	}
	
	public abstract void subInitialize();
	
	public void setSource(ViewItem source){
		mySource = source;
	}
	
	public class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myList.removeItem(myList.getSelectedIndex());
			System.out.println(myList.getModel().getSize());
		}
		
	}
}
