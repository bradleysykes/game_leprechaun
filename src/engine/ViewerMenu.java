package engine;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ViewerMenu extends JMenu {
	
	private JMenuItem myLoadGameItem;
	private JMenuItem myExitGameItem;
	
	public ViewerMenu(String title) {
		super(title);
		myLoadGameItem = new JMenuItem("Load Game");
		myExitGameItem = new JMenuItem("Exit Game");
		myLoadGameItem.addActionListener(new LoadGameListener());
		//myExitGameItem.addActionListener(new ExitGameListener());
		add(myLoadGameItem);
		add(myExitGameItem);
	}
	
}
