package engine;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GameViewer extends JFrame {
	
	private final String myTitle = "OOGASALAD";
	private GameEngine myGameEngine;
	private JMenuBar myMenuBar;
	
	
	public GameViewer() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(myTitle);
		JPanel componentPane = new JPanel();
		componentPane.setLayout(new BoxLayout(componentPane, BoxLayout.PAGE_AXIS));
		myMenuBar = new JMenuBar();
		myMenuBar.add(new ViewerMenu("Options", myGameEngine));
		setJMenuBar(myMenuBar);
		myGameEngine = new GameEngine();
		componentPane.add(myGameEngine);
		add(componentPane);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public GameEngine getGameEngine() {
		return myGameEngine;
	}
	
	
}
