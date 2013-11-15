package engine;

import java.awt.FlowLayout;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ViewerMenu extends JMenu {
	
	private JMenuItem myLoadGameItem;
	private JMenuItem myExitGameItem;
	
	public ViewerMenu(String title, GameEngine gameEngine) {
		super(title);
		myLoadGameItem = new JMenuItem("Load Game");
		myExitGameItem = new JMenuItem("Exit Game");
		myLoadGameItem.addActionListener(new LoadGameListener(gameEngine));
		//myExitGameItem.addActionListener(new ExitGameListener());
		add(myLoadGameItem);
		add(myExitGameItem);
	}
	
}
