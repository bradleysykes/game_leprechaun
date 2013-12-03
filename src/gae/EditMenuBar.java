package gae;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditMenuBar extends JMenuBar implements Constants {
	protected Controller myController;
	protected JMenuItem mySaveItem, myFileViewItem, myRunItem;
	public EditMenuBar(Controller controller){
		myController = controller;
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
		JMenuItem saveAsItem = new JMenuItem("Save As");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myController.exit();
			}
			
		});
		mySaveItem = new JMenuItem("Save");
		mySaveItem.setEnabled(false);
		fileMenu.add(saveAsItem);
		fileMenu.add(mySaveItem);
		fileMenu.add(exitItem);
		mySaveItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
			
		});
		saveAsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(myController.canSave()){
					saveAs();
					activateSaveItem();
				}
			}

		});
		JMenu gameMenu = new JMenu("Game");
		this.add(gameMenu);
		myFileViewItem = new JMenuItem("View XML");
		myFileViewItem.setEnabled(false);
		myFileViewItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFile();
			}
			
		});
		fileMenu.add(myFileViewItem);
		JMenuItem mapSetup = new JMenuItem("Initial Map Setup");
		myRunItem = new JMenuItem("Run");
		myRunItem.setEnabled(false);
		myRunItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// close GAE instance of JGame
				//create instance of Player
				//load file
				save();
				myController.closeMap();
			}
			
		});
		mapSetup.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(new JLabel(), "Height will be 500, Width will be 500");
				
			}
			
		});
		gameMenu.add(mapSetup);
		gameMenu.add(myRunItem);
	}

	protected void openFile() {
		// need to know where file resides
		myController.displayFile();
	}
	
	private void save() {
		myController.save();
	}


	private void saveAs() {
		myController.getAndSaveState("");
	}
	
	public void activateSaveItem(){
		mySaveItem.setEnabled(true);
		myFileViewItem.setEnabled(true);
		myRunItem.setEnabled(true);
	}
}
