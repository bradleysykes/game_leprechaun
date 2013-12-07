package engine.gui;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.GameEngine;
import model.unit.Unit;

public class SpawnerViewer extends JFrame {
	
	private SpawnerPanel myListPanel;
	private IconPanel myIconPanel;
	
	public SpawnerViewer(List<Unit> unitList, GameEngine gameEngine) {
		setLayout(new FlowLayout());
		myListPanel = new SpawnerPanel(unitList, this, gameEngine);
		myIconPanel = new IconPanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(myListPanel);
		add(myIconPanel);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public SpawnerPanel getSpawnerPanel() {
		return myListPanel;
	}
	
	public IconPanel getIconPanel() {
		return myIconPanel;
	}
	
}
