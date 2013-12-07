package engine.listeners;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.unit.Unit;
import engine.gui.IconPanel;
import engine.gui.SpawnerPanel;
import engine.gui.StatusArea;

public class SpawnerListSelectionListener implements ListSelectionListener {
	
	private JList<String> myUnitList;
	private SpawnerPanel mySpawnerPanel;
	private IconPanel myIconPanel;
	private StatusArea myStatusArea;
	
	public SpawnerListSelectionListener(JList<String> unitList, IconPanel iconPanel, StatusArea statusArea) {
		myUnitList = unitList;
		myIconPanel = iconPanel;
		myStatusArea = statusArea;
	}
	
	public void valueChanged(ListSelectionEvent e)  {
		int index = myUnitList.getSelectedIndex();
		if (index != -1) {
			Unit toDisplay = mySpawnerPanel.getUnits().get(index);
			String imagePath = mySpawnerPanel.unitImagePath(toDisplay);
			myIconPanel.setIcon(imagePath);
			UnitListSelectionListener.setStatusArea(toDisplay.getStatCollection("Attributes"), myStatusArea, toDisplay);
		}
	}
}
