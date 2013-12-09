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
	private StatusArea myStatusArea;
	
	public SpawnerViewer(List<Unit> unitList, GameEngine gameEngine) {
		setLayout(new FlowLayout());
		myStatusArea = new StatusArea("");
		myIconPanel = new IconPanel();
		myListPanel = new SpawnerPanel(unitList, this, gameEngine);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(myListPanel);
		add(myStatusArea);
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
	
	public StatusArea getStatusArea() {
		return myStatusArea;
	}
	
}
