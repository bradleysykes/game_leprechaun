package engine.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class AbilityListListener implements ItemListener {
	
	public void itemStateChanged(ItemEvent e) {
		JComboBox abilityComboBox = (JComboBox) e.getSource();
	}
	
}
