package gae.menu_bar;

import gae.Constants;
import gae.Controller;
import gae.EditGUI;

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
import javax.swing.KeyStroke;

public class EditMenuBar extends JMenuBar implements Constants {
	
	protected Controller myController;
	protected GUIMenu myFileMenu, myGameMenu;
	
	public EditMenuBar(Controller controller){
		myController = controller;
		myController.setMenuBar(this);
		myFileMenu = new FileMenu(myController,this);
		this.add(myFileMenu);
		myGameMenu = new GameMenu(myController,this);
		this.add(myGameMenu);
	}
	
	public void activateSaveItem(){
		myFileMenu.enableAll();
		myGameMenu.enableAll();
	}

}
