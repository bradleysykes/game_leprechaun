package gae.dialogues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gae.Controller;
import gae.panels.EditPanel;
import gae.panels.MapPanel;
import gae.popup_menus.GAEPopupMenu;

public class MapPopupMenu extends GAEPopupMenu {
	
	private MapPanel myMapPanel;

	public MapPopupMenu(Controller controller, MapPanel mapPanel) {
		super(controller);
		myMapPanel = mapPanel;
		initialize();
	}

	@Override
	public void subInitialize() {
		// TODO Auto-generated method stub
		JMenuItem clearItem = new JMenuItem("Clear Map");
		clearItem.addActionListener(new ClearMapListener());
	}
	
	private class ClearMapListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			myMapPanel.clearMap();
		}
		
	}

}
