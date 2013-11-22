package gae.listeners;

import gae.panel_lists.BoardList;
import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.ViewItem;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupListener extends MouseAdapter {
		
		
		private GAEPopupMenu myMenu;
		private BoardList mySource;
	
		public PopupListener(GAEPopupMenu menu, BoardList source){
			myMenu = menu;
			mySource = source;
		}
		
		public void mousePressed(MouseEvent e) {
	        maybeShowPopup(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	        maybeShowPopup(e);
	    }

	    private void maybeShowPopup(MouseEvent e) {
	        if (e.isPopupTrigger()) {
	            myMenu.show(e.getComponent(),e.getX(), e.getY());
	            //finds the selected ViewItem
	            mySource.setSelectedIndex(mySource.locationToIndex(e.getPoint()));
	            boolean x = mySource.getSelectionModel().isSelectedIndex(0);
	            myMenu.setSource((ViewItem)mySource.getSelectedValue());
	        }
	    }

}
