package gae;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
	Controller myController;
	public EditMenuBar(Controller controller){
		myController = controller;
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
		JMenuItem saveItem = new JMenuItem("Export XML");
		fileMenu.add(saveItem);
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveData();
			}

		});
		JMenu gameMenu = new JMenu("Game");
		this.add(gameMenu);
		JMenuItem viewFileItem = new JMenuItem("View XML");
		viewFileItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFile();
			}
			
		});
		fileMenu.add(viewFileItem);
		JMenuItem mapSetup = new JMenuItem("Initial Map Setup");
		mapSetup.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(new JLabel(), "Height will be 500, Width will be 500");
				
			}
			
		});
		gameMenu.add(mapSetup);
	}
	
	protected void openFile() {
		// need to know where file resides
		FILE_CHOOSER.showOpenDialog(this);
		File file = FILE_CHOOSER.getSelectedFile();
		myController.displayFile(file);
	}

	private void saveData() {
		myController.getAndSaveState();
		
	}
}
