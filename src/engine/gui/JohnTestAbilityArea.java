package engine.gui;

import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private Collection<JButton> myButtons = new ArrayList<JButton>();

	public JohnTestAbilityArea(GameEngine ge) {
		myEngine = ge;		
	}
	
	public void clear() {
		myAbilities = null;
		for (JButton b : myButtons){
			this.remove(b);
		}
		myButtons.clear();
	}

	public void refreshAbilities(StatCollection a) {
		for (Stat s : a.getStats()) {
			AbilityButton button = new AbilityButton(myEngine,(Ability) myAbilities.getStat(s.getName()));
			this.add(button);
			myButtons.add(button);
		}
		this.revalidate();
	}

	public void setUnit(Unit unit) {
		this.clear();
		myAbilities = (Abilities) unit.getStatCollection("Abilities");
		this.refreshAbilities(myAbilities);
	}

}
