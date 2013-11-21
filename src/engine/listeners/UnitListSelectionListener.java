package engine.listeners;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.unit.Unit;
import engine.GameViewer;
import engine.gui.AbilityListArea;
import engine.gui.UnitListArea;
import engine.gui.UnitStatusArea;

public class UnitListSelectionListener implements ListSelectionListener {
	
	private UnitListArea myUnitListArea;
	
	public UnitListSelectionListener(UnitListArea unitListArea) {
		myUnitListArea = unitListArea;
	}

	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		int index = list.getSelectedIndex();
		if (index != -1) {
			Unit selectedUnit = myUnitListArea.getUnits().get(index);
			//populate AbilityList, and UnitStatusArea
			AbilityListArea abilityListArea = (AbilityListArea) GameViewer.getActionPanel().getAbilityListArea();
			UnitStatusArea unitStatusArea = (UnitStatusArea) GameViewer.getFeedbackPanel().getUnitStatusArea();
			
		}
	}

}
