package gae;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupListener implements MouseListener {

	

		@Override
		public void mouseClicked(MouseEvent e) {
			showPopup(e);
		}

		private void showPopup(MouseEvent e) {
			if(e.isPopupTrigger()){
				JPopupMenu jMenu = new JPopupMenu();
				jMenu.add(new JMenuItem("Delete"));
				jMenu.validate();
			    jMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

}
