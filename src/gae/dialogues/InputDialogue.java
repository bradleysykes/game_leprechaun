package gae.dialogues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gae.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class InputDialogue extends JFrame {
	
	protected Controller myController;
	
	public InputDialogue(Controller controller){
		myController = controller;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
	}
	
	public abstract JPanel createGutsPanel();
	
	/**
	 * Send information entered by user directly to the Controller. 
	 */
	public abstract void postInput();
	
	public void disposeDialogue() {
		this.dispose();	
	}
	
	protected class GetDataAction implements ActionListener {
		protected GetDataAction() {}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			postInput();
		}
	}
}
