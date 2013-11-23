package gae.listeners;

import gae.dialogues.InputDialogue;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GAEWindowListener implements WindowListener {
	
	private InputDialogue myDialogue;
	
	public GAEWindowListener(InputDialogue dialogue){
		myDialogue = dialogue;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// call this input dialogue's closing methods
		myDialogue.onClose();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
