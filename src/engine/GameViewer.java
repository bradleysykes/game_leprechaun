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
		myGameEngine = new GameEngine();
		
		myMenuBar = new JMenuBar();
		myMenuBar.add(new ViewerMenu("Menu", myGameEngine));
		setJMenuBar(myMenuBar);
		
		JPanel enginePane = new JPanel();
		enginePane.setLayout(new BoxLayout(enginePane, BoxLayout.PAGE_AXIS));
		enginePane.add(myGameEngine);
		add(enginePane);
		
		JPanel controlPane = new JPanel();
		controlPane.setLayout(new FlowLayout());
		//controlPane.add()
		
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public GameEngine getGameEngine() {
		return myGameEngine;
	}
	
	
}
