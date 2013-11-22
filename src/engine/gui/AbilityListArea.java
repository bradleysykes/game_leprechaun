package engine.gui;

import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Ability;
import model.unit.Unit;

public class AbilityListArea extends JPanel {

	private JComboBox<String> myComboBox;
	private DefaultComboBoxModel<String> myComboBoxModel;
	private List<Ability> myAbilities;
	private Unit myUnit;
	private final Dimension mySize = new Dimension(150, 10);
	
	public AbilityListArea() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		myAbilities = new ArrayList<Ability>();
		myComboBoxModel = new DefaultComboBoxModel<String>();
		myComboBox = new JComboBox<String>(myComboBoxModel);
		myComboBox.setPreferredSize(mySize);
		
		add(new Label("Abilities:"));
		add(myComboBox);
	}
	
	public void clearAbilities() {
		myAbilities.clear();
	}
	
	public void refreshAbilities(List<Ability> abilities) {
		myAbilities = abilities;
		myComboBoxModel.removeAllElements();
		for (Ability ability : abilities) {
			myComboBoxModel.addElement(ability.getID());
		}
	}
	
	public void setUnit(Unit unit) {
		myUnit = unit;
	}
	
}
