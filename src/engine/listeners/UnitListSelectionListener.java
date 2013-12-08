package engine.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Abilities;
import model.Ability;
import model.Attributes;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;
import engine.GameEngine;
import engine.GameViewer;
import engine.gui.AbilityListArea;
import engine.gui.JohnTestAbilityArea;
import engine.gui.StatusArea;
import engine.gui.UnitListArea;
import engine.gui.UnitStatusArea;

public class UnitListSelectionListener implements ListSelectionListener {
	
	private UnitListArea myUnitListArea;
	private GameEngine myGameEngine;
	
	public UnitListSelectionListener(UnitListArea unitListArea, GameEngine gameEngine) {
		myUnitListArea = unitListArea;
		myGameEngine = gameEngine;
	}

	public void valueChanged(ListSelectionEvent e) {
		JList<String> list = (JList<String>) e.getSource();
		int index = list.getSelectedIndex();
		if (index != -1) {
			Unit selectedUnit = myUnitListArea.getUnits().get(index);
			
			JohnTestAbilityArea abilityListArea = (JohnTestAbilityArea) myGameEngine.getGameViewer().getActionPanel().getAbilityListArea();
			//AbilityListArea abilityListArea = (AbilityListArea) myGameEngine.getGameViewer().getActionPanel().getAbilityListArea();
			UnitStatusArea unitStatusArea = (UnitStatusArea) GameViewer.getFeedbackPanel().getUnitStatusArea();
			
			abilityListArea.setUnit(selectedUnit);
			
			StatCollection attributesStatCollection = selectedUnit.getStatCollection("Attributes");
			setStatusArea(attributesStatCollection, unitStatusArea, selectedUnit);
		}
	}
	
	public static void setStatusArea(StatCollection collection, StatusArea statusArea, Unit unit) {
		Attributes attributes = (Attributes) collection;
		List<Stat> attributeStatList = attributes.getStats();
		String attributeReport = unit.getID().split("\\|")[0] + "\n";
		for (Stat stat : attributeStatList) {
			attributeReport += stat.getName() + ":" + " " + stat.getValue() + "\n";
		}
		statusArea.setStatusText(attributeReport);
	}

}
