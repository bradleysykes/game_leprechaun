package gae.popup_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.Player;

import gae.Controller;
import gae.panel_lists.BoardList;
import gae.popup_menus.GAEPopupMenu.DeleteListener;
import gae.popup_menus.TilePopupMenu.FillListener;


public class UnitPopupMenu extends GAEPopupMenu {
	private BoardList myListSource;
	public UnitPopupMenu(Controller controller, BoardList list){
		super(controller);
		myListSource = list;
		initialize();
	}
	
	@Override
	public void subInitialize() {
		// TODO Auto-generated method stub
		JMenuItem item = new JMenuItem("Edit");
		item.addActionListener(new EditListener());
		this.add(item);
		JMenu playerSubMenu = new JMenu("Assign Player");
		this.add(playerSubMenu);
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(new DeleteListener(myListSource));
		this.add(delete);
	}
	
	public class EditListener implements ActionListener{
		
		/**
		 * open view that allows user to edit existing subtype
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Edit begins");
			
		}
		
	}

}
