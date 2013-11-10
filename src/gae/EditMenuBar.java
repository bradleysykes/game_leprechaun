package gae;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EditMenuBar extends JMenuBar {
	
	
	
	public EditMenuBar(){
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
		fileMenu.add(new JMenuItem("Export XML"));
		JMenu gameMenu = new JMenu("Game");
		this.add(gameMenu);
		gameMenu.add(new JMenuItem("Preferences"));
	}
}
