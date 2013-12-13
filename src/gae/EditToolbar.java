package gae;

import gae.dialogues.BoardSizeDialogue;
import gae.dialogues.PlayerDialogue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class EditToolbar extends JPanel {
	
	private Controller myController;
	private JButton myResizeButton;
	private JButton myPlayerButton;
	
	public EditToolbar(Controller controller){
		myController = controller;
		JToolBar editToolbar = new JToolBar();
		JButton numPlayersButton = new JButton("Edit Number of Players");
		numPlayersButton.addActionListener(new EditNumPlayersActionListener());
		editToolbar.add(numPlayersButton);
		JButton resizeButton = new JButton("Resize Map");
		resizeButton.addActionListener(new ResizeListener());
		resizeButton.setEnabled(false);
		myResizeButton = resizeButton;
		myPlayerButton = numPlayersButton;
		myPlayerButton.setEnabled(false);
		myController.setToolbar(this);
		editToolbar.add(resizeButton);
		this.add(editToolbar);
	}
	
	private class ResizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane alertPane = new JOptionPane("WARNING: Resizing the map will delete all map data!");
			JDialog dialog = alertPane.createDialog(null,"Memory alert");
			dialog.setLocation(10, 10);
			dialog.setVisible(true);
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

	public void enableResize() {
		myResizeButton.setEnabled(true);
	}
	
	public void enablePlayerEdit(){
		myPlayerButton.setEnabled(true);
	}
	
}
