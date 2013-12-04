package engine.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import engine.GameEngine;
import engine.gui.AbilityListArea;

public class AbilityListListener implements ItemListener {
	
	private boolean isActive = true;
	private AbilityListArea myAbilityList;
	
	public AbilityListListener(AbilityListArea abilityList) {
		myAbilityList = abilityList;
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (isActive) {
			JComboBox abilityComboBox = (JComboBox) e.getSource();
			String abilityName = abilityComboBox.getSelectedItem().toString();
			System.out.println(abilityName);
			myAbilityList.setAbilitySelection(abilityName);
		}
		//JComboBox abilityComboBox = (JComboBox) e.getSource();
		
	}
	
	public void setActive(boolean active) {
		isActive = active;
	}
	
}
