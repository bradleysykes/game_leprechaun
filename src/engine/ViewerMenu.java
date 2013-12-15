package engine;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import engine.listeners.LoadGameListener;
import gae.view.EditGUI;
import gae.view.LaunchGUI;

public class ViewerMenu extends JMenu {
	
	private JMenuItem myLoadGameItem;
	private JMenuItem myExitGameItem;
	private GameViewer myParent;
	
	public ViewerMenu(String title, GameEngine gameEngine, GameViewer parent) {
		super(title);
		myParent = parent;
		myLoadGameItem = new JMenuItem("Load Game");
		myExitGameItem = new JMenuItem("Exit Game");
		JMenuItem editItem = new JMenuItem("Edit Game");
		editItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GameEngine engine = myParent.getGameEngine();
				File gameFile = engine.getSourceFile();
				engine.destroy();
				myParent.stopAudio();
				myParent.dispose();
				new EditGUI(gameFile.getPath());
			}
			
		});
		myExitGameItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myParent.dispose();
				myParent.stopAudio();
				new LaunchGUI();
			}
			
		});
		myLoadGameItem.addActionListener(new LoadGameListener(gameEngine));
		//myExitGameItem.addActionListener(new ExitGameListener());
		add(myLoadGameItem);
		add(myExitGameItem);
		add(editItem);
	}
	
}
