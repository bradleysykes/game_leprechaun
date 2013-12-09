package gae;

import gae.dialogues.BoardSizeDialogue;
import gae.dialogues.PlayerDialogue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class EditToolbar extends JPanel {
	Controller myController;
	public EditToolbar(Controller controller){
		myController = controller;
		JToolBar editToolbar = new JToolBar();
		JButton numPlayersButton = new JButton("Edit Number of Players");
		numPlayersButton.addActionListener(new EditNumPlayersActionListener());
		editToolbar.add(numPlayersButton);
		JButton resizeButton = new JButton("Resize Map");
		resizeButton.addActionListener(new ResizeListener());
		editToolbar.add(resizeButton);
		this.add(editToolbar);
	}
	
	private class ResizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myController.closeMap();
			new BoardSizeDialogue(myController);
		}
		
	}
	
	public class EditNumPlayersActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new PlayerDialogue(myController);
			
		}
		
	}
	
}
