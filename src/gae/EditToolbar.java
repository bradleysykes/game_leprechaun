package gae;

import gae.dialogues.PlayerDialogue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class EditToolbar extends JPanel {
	Controller myController;
	public EditToolbar(Controller controller){
		myController = controller;
		JToolBar editToolbar = new JToolBar();
		JButton numPlayersButton = new JButton("Edit Number of Players");
		numPlayersButton.addActionListener(new editNumPlayersAction());
		editToolbar.add(numPlayersButton);
		editToolbar.add(new JButton("Task 2"));
		editToolbar.add(new JButton("Task 3"));
		this.add(editToolbar);
	}
	class editNumPlayersAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new PlayerDialogue(myController);
			
		}
		
	}
	
}
