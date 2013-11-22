package gae.popup_menus;

import gae.Controller;
import gae.panel_lists.BoardList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class TilePopupMenu extends GAEPopupMenu {
	
	public TilePopupMenu(Controller controller, BoardList source){
		super(controller, source);
	}
	
	@Override
	public void subInitialize() {
		// TODO Auto-generated method stub
		JMenuItem item = new JMenuItem("Fill Map");
		item.addActionListener(new FillListener());
		this.add(item);
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
