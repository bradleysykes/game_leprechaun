package engine.gui;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import engine.GameEngine;
import engine.listeners.AbilityListListener;
import model.Abilities;
import model.Ability;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class JohnTestAbilityArea extends JPanel {

	private GameEngine myEngine;
	private Abilities myAbilities;
	private Collection<JButton> myButtons;

	public JohnTestAbilityArea(GameEngine ge) {
		myEngine = ge;		
	}
	
	public void clear() {
		myAbilities = null;
		for (JButton b : myButtons){
			this.remove(b);
		}
	}

	public void refreshAbilities(StatCollection a) {
		this.clear();
		
		for (Stat s : a.getStats()) {
			this.add(new AbilityButton(myEngine,(Ability) myAbilities.getStat(s.getName())));
		}
	}

	public void setUnit(Unit unit) {
		myAbilities = (Abilities) unit.getStatCollection("Abilities");
		this.refreshAbilities(myAbilities);
	}

}
