package gae.popup_menus;

import gae.BoardBuffer;
import gae.Controller;
import gae.panel_lists.BoardList;
import gae.popup_menus.GAEPopupMenu.DeleteListener;
import gae.viewitems.BoardListViewItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class TilePopupMenu extends GAEPopupMenu {
	private BoardList myListSource;
	public TilePopupMenu(Controller controller, BoardList source){
		super(controller);
		myListSource = source;
		initialize();
	}
	
	@Override
	public void subInitialize() {
		// TODO Auto-generated method stub
		JMenuItem item = new JMenuItem("Fill Map");
		item.addActionListener(new FillListener());
		this.add(item);
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(new DeleteListener(myListSource));
		this.add(delete);
		JMenuItem removeFromMap = new JMenuItem("Remove All From Map");
		removeFromMap.addActionListener(new RemoveListener(myListSource));
		this.add(removeFromMap);
	}
	
	public class FillListener implements ActionListener{
		
		/**
		 * fills every position on the map with this type of tile
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//send view item to MapPanel
			System.out.println("fill map performed");
			myController.fillBoard(mySource);
		}
		
	}
}
