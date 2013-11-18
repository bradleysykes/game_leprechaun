package gae;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditMenuBar extends JMenuBar {
	Controller myController;
	public EditMenuBar(Controller controller){
		myController = controller;
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
		JMenuItem saveButton = new JMenuItem("Export XML");
		fileMenu.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveData();
			}

		});
		JMenu gameMenu = new JMenu("Game");
		this.add(gameMenu);
		JMenuItem mapSetup = new JMenuItem("Initial Map Setup");
		mapSetup.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(new JLabel(), "Height will be 500, Width will be 500");
				
			}
			
		});
		gameMenu.add(mapSetup);
	}
	
	private void saveData() {
		myController.getAndSaveState();
	}
}
