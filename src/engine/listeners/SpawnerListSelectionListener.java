package engine.listeners;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.unit.Unit;
import engine.gui.IconPanel;
import engine.gui.SpawnerPanel;

public class SpawnerListSelectionListener implements ListSelectionListener {
	
	private JList<String> myUnitList;
	private SpawnerPanel mySpawnerPanel;
	private IconPanel myIconPanel;
	
	public SpawnerListSelectionListener(JList<String> unitList, IconPanel iconPanel) {
		myUnitList = unitList;
		myIconPanel = iconPanel;
	}
	
	public void valueChanged(ListSelectionEvent e)  {
		int index = myUnitList.getSelectedIndex();
		if (index != -1) {
			Unit toDisplay = mySpawnerPanel.getUnits().get(index);
			String imagePath = mySpawnerPanel.unitImagePath(toDisplay);
			myIconPanel.setIcon(imagePath);
		}
	}
}
