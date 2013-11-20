package engine.gui;

import java.awt.Dimension;
import java.awt.Label;
import java.util.HashMap;
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
	private Map<String, Ability> myAbilities;
	private Unit myUnit;
	private final Dimension mySize = new Dimension(150, 10);
	
	public AbilityListArea() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		myAbilities = new HashMap<String, Ability>();
		myComboBoxModel = new DefaultComboBoxModel<String>();
		myComboBox = new JComboBox<String>(myComboBoxModel);
		myComboBox.setPreferredSize(mySize);
		
		add(new Label("Abilities:"));
		add(myComboBox);
	}
	
	
}
