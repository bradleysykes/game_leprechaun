package engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.unit.Unit;

import engine.gui.ActionPanel;
import engine.gui.FeedbackPanel;
import engine.gui.NextTurnButton;
import engine.listeners.NextTurnListener;

public class GameViewer extends JFrame {
	
	private final String myTitle = "OOGASALAD";
	private GameEngine myGameEngine;
	private JMenuBar myMenuBar;
	private static ActionPanel myActionPanel;
	private static FeedbackPanel myFeedbackPanel;
	
	public GameViewer() {
		// Initializing Steps
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(myTitle);
		myGameEngine = new GameEngine(this);
		myGameEngine.setMaximumSize(new Dimension(GameEngine.getViewerWidth(), GameEngine.getViewerHeight()));
		
		// Add Menu Bar
		myMenuBar = new JMenuBar();
		myMenuBar.add(new ViewerMenu("Menu", myGameEngine));
		setJMenuBar(myMenuBar);
		
		// Create Container. Set layout.
		Container containerPane = this.getContentPane();
		containerPane.setLayout(new BoxLayout(containerPane, BoxLayout.PAGE_AXIS));
		
		// Create control pane. Make Button. Make Text Boxes.
		JPanel controlPane = new JPanel();
		controlPane.setLayout(new FlowLayout());
		controlPane.setPreferredSize(new Dimension(1000, 250));
		
		//make and add various components to controlPane
		myActionPanel = new ActionPanel(myGameEngine);
		myFeedbackPanel = new FeedbackPanel();
		
		controlPane.add(myActionPanel);
		controlPane.add(myFeedbackPanel);
		

		// Add Panels to Container
		containerPane.add(myGameEngine);
		containerPane.add(controlPane);
		
		pack();
		setVisible(true);
	}
	
	public GameEngine getGameEngine() {
		return myGameEngine;
	}
	
	public static ActionPanel getActionPanel() {
		return myActionPanel;
	}
	
	public static FeedbackPanel getFeedbackPanel() {
		return myFeedbackPanel;
	}

	public void setSelectedUnit(Unit u) {
		myActionPanel.setSelectedUnit(u);
	}

	public void launch(String myGameFilePath) {
		//method to launch game from file when run button pressed in GAE
		myGameEngine.setSourceFile(new File(myGameFilePath));
		new DataPrimer(myGameEngine);
	}
	
}
