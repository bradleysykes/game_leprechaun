package engine.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import model.unit.Unit;
import engine.gui.SpawnerPanel;

public class SpawnerListener implements ActionListener {

	private SpawnerPanel mySpawnerPanel;
	private JFrame mySpawnerViewer;
	
	public SpawnerListener(SpawnerPanel spawnerPanel, JFrame spawnerViewer) {
		mySpawnerPanel = spawnerPanel;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		JList<String> unitList =  mySpawnerPanel.getList();
		int index = unitList.getSelectedIndex();
		Unit toSpawn = mySpawnerPanel.getUnits().get(index);
		
		//(call model method to deliver unit here)
		
		//mySpawnerViewer.dispatchEvent(new WindowEvent(mySpawnerViewer, WindowEvent.WINDOW_CLOSING); // dispose() lets us reuse i think
		mySpawnerViewer.dispose();
	}
	
	
	
}
