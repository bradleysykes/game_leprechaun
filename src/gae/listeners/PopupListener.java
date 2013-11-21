package gae.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupListener extends MouseAdapter {
		
		
		private JPopupMenu myMenu;
	
		public PopupListener(JPopupMenu menu){
			myMenu = menu;
		}
		
		public void mousePressed(MouseEvent e) {
	        maybeShowPopup(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	        maybeShowPopup(e);
	    }

	    private void maybeShowPopup(MouseEvent e) {
	        if (e.isPopupTrigger()) {
	            myMenu.show(e.getComponent(),
	                       e.getX(), e.getY());
	        }
	    }

}
