package gae;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class PopupEventQueue extends EventQueue {
	
	JPopupMenu myPopup;
	
	public PopupEventQueue() {
		// TODO Auto-generated constructor stub
	}
	
	protected void dispatchEvent(AWTEvent event){
		super.dispatchEvent(event);
		if(!(event instanceof MouseEvent)){
		      return;
		    }
		    MouseEvent me = (MouseEvent)event;
		    if(!me.isPopupTrigger()) {
		      return;
		    }
		    if( !(me.getSource() instanceof Component) ) {
		      return;
		    }
		    Component comp = SwingUtilities.getDeepestComponentAt((Component)
		me.getSource(),me.getX(), me.getY());
		    if( !(comp instanceof JPanel)){
		      return;
		    }
		    if(MenuSelectionManager.defaultManager().getSelectedPath().length > 0){
		      return;
		    }
		    createTextActionMenu((JTextComponent)comp);
		    showPopup((Component)me.getSource(), me);
		  }
	
	private void showPopup(Component source, MouseEvent me) {
		 	myPopup.validate();
		    myPopup.show(source, me.getX(), me.getY());
	}

	private void createTextActionMenu(JTextComponent text){
		JPopupMenu jMenu = new JPopupMenu();
		jMenu.add(new JMenuItem("Delete"));
	}

}

