package gae.popup_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class TilePopupMenu extends GAEPopupMenu {

	@Override
	public void subInitialize() {
		// TODO Auto-generated method stub
		JMenuItem item = new JMenuItem("Fill Map");
		item.addActionListener(new FillListener());
		this.add(item);
	}
	
	public class FillListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("fill map performed");
		}
		
	}

}
