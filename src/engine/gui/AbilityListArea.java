package engine.gui;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import engine.GameEngine;
import engine.listeners.AbilityListListener;
import model.Abilities;
import model.Ability;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class AbilityListArea extends JPanel {

	private GameEngine myEngine;
	private Abilities myAbilities;
	private JComboBox<String> myComboBox;
	private boolean myStatus = false;
	private AbilityListListener myListener;

	public AbilityListArea(GameEngine ge) {
		myEngine = ge;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		myComboBox = new JComboBox<String>();
		this.add(new Label("Abilities:"));
		this.add(myComboBox);
/*		myComboBox.addActionListener(new ActionListener(){
					
			//trying an itemListener instead
			public void actionPerformed(ActionEvent arg0) {
				if(myStatus){
					System.out.println(myComboBox.getSelectedItem().toString());
					Ability ability = (Ability) myAbilities.getStat(myComboBox.getSelectedItem().toString());
					myEngine.getModel().setAbility(ability);
				}
				else{		// Bug with first click. Should be a better solution.
					//myStatus = true;
				}
			}
		});*/
		myListener = new AbilityListListener(this);
		myComboBox.addItemListener(myListener);
		
	}
	
	public void setAbilitySelection(String abilityName) {
		Ability ability = (Ability) myAbilities.getStat(abilityName);
		myEngine.getModel().setAbility(ability);
	}
	
	public void clear() {
		myAbilities = null;
		myListener.setActive(false);
		myComboBox.removeAllItems();
		myListener.setActive(true);
	}

	public void refreshAbilities(StatCollection a) {
		myListener.setActive(false);
		myComboBox.removeAllItems();
		for (Stat s : a.getStats()) {
			myComboBox.addItem(s.getName());
		}
		myComboBox.revalidate();
		myListener.setActive(true);
	}

	public void setUnit(Unit unit) {
		myAbilities = (Abilities) unit.getStatCollection("Abilities");
		this.refreshAbilities(myAbilities);
	}

}
