package gae;
import gae.menu_bar.EditMenuBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import data.GameElements;
import data.decoder.DataManager;


public class EditGUI extends JFrame implements Constants {
	
	private Controller myController;
	
	public EditGUI(){
		myController = new Controller();
		myController.setGUI(this);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.red);
		this.add(new Workspace(myController),BorderLayout.CENTER);
		this.setPreferredSize(EDITGUI_INITIAL_SIZE);
		this.setJMenuBar(new EditMenuBar(myController));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public EditGUI(String openPath) {
		this();
		DataManager manager = new DataManager();
		GameElements openElements = manager.getGameElements(new File(openPath));
		myController.setGameFilePath(openPath);
		try{
			myController.loadData(openElements);
		}
		catch(Exception e){
			myController.closeMap();
			this.dispose();
			new EditGUI();
		}
	}
	

}
