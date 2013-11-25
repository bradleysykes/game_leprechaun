package engine.gui;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import engine.GameEngine;

import model.Abilities;
import model.Ability;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class AbilityListArea extends JPanel {

	private GameEngine myEngine;
	private Abilities myAbilities;
	private JComboBox<String> myComboBoxModel;
	
	public AbilityListArea(GameEngine ge) {
		myEngine = ge;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		myComboBoxModel = new JComboBox<String>();
		myComboBoxModel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(myComboBoxModel.getSelectedItem().toString());
				Ability ability = (Ability) myAbilities.getStat(myComboBoxModel.getSelectedItem().toString());
				myEngine.getModel().setAbility(ability);
			}
		});
		this.add(new Label("Abilities:"));
		this.add(myComboBoxModel);
	}
	
	public void refreshAbilities(StatCollection a) {
		myComboBoxModel.removeAllItems();
		for (Stat s : a.getStats()) {
			myComboBoxModel.addItem(s.getName());
		}
	}
	
	public void setUnit(Unit unit) {
		myAbilities = (Abilities) unit.getStatCollection("Abilities");
		this.refreshAbilities(myAbilities);
	}
	
}
