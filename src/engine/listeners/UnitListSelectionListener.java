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
		JList<String> list = (JList<String>) e.getSource();
		int index = list.getSelectedIndex();
		if (index != -1) {
			Unit selectedUnit = myUnitListArea.getUnits().get(index);
			
			AbilityListArea abilityListArea = (AbilityListArea) GameViewer.getActionPanel().getAbilityListArea();
			UnitStatusArea unitStatusArea = (UnitStatusArea) GameViewer.getFeedbackPanel().getUnitStatusArea();
			
			StatCollection abilitiesStatCollection = selectedUnit.getStatCollection("Abilities");
			populateAbilityListArea(abilitiesStatCollection, abilityListArea);
			abilityListArea.setUnit(selectedUnit);
			
			StatCollection attributesStatCollection = selectedUnit.getStatCollection("Attributes");
			setUnitStatusArea(attributesStatCollection, unitStatusArea, selectedUnit);
		}
	}
	
	private void populateAbilityListArea(StatCollection collection, AbilityListArea abilityListArea) {
		Abilities abilities = (Abilities) collection;
		List<Stat> abilityStatList = abilities.getStats();
		List<Ability> abilityList = new ArrayList<Ability>();
		for (Stat stat : abilityStatList) {
			abilityList.add((Ability) stat);
		}
		
		abilityListArea.refreshAbilities(abilityList);
	}
	
	private void setUnitStatusArea(StatCollection collection, UnitStatusArea unitStatusArea, Unit unit) {
		Attributes attributes = (Attributes) collection;
		List<Stat> attributeStatList = attributes.getStats();
		String attributeReport = unit.getID() + "\n";
		for (Stat stat : attributeStatList) {
			attributeReport += stat.getName() + ":" + " " + stat.getValue() + "\n";
		}
		unitStatusArea.setStatusText(attributeReport);
	}

}
