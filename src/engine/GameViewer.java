package engine;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class GameViewer extends JFrame {
	
	private final String myTitle = "OOGASALAD";
	private GameEngine myGameEngine;
	private JMenuBar myMenuBar;
	
	
	public GameViewer() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(myTitle);
		setLayout(new FlowLayout());
		myGameEngine = new GameEngine();
		add(myGameEngine);
		myMenuBar = new JMenuBar();
		myMenuBar.add(new ViewerMenu("Options"));
		add(myMenuBar);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public GameEngine getGameEngine() {
		return myGameEngine;
	}
	
	
}
