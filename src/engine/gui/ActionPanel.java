package engine.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import engine.GameEngine;

import model.unit.Unit;

public class ActionPanel extends JPanel {
	
	private Dimension mySize = new Dimension(300, 230);
	private JButton myNextTurnButton;
	private JPanel myUnitListArea;
	private JohnTestAbilityArea myAbilityListArea;
	//private AbilityListArea myAbilityListArea;
	private GameEngine myGameEngine;
	
	public ActionPanel(GameEngine ge) {
		myGameEngine = ge;
		//setPreferredSize(mySize);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Actions");
		titledBorder.setTitleJustification(TitledBorder.LEFT);
		setBorder(titledBorder);
		
		myUnitListArea = new UnitListArea(myGameEngine);
		myAbilityListArea = new JohnTestAbilityArea(myGameEngine);
		//myAbilityListArea = new AbilityListArea(myGameEngine);
		
		add(new ButtonArea(myGameEngine));
		add(myUnitListArea);
		add(myAbilityListArea);
	}
	
	public JPanel getUnitListArea() {
		return myUnitListArea;
	}
	
	public JPanel getAbilityListArea() {
		return myAbilityListArea;
	}
	
	public void setSelectedUnit(Unit u){
		myAbilityListArea.setUnit(u);
		//myUnitListArea.setUnit(u); ?? what does this panel do?
	}
	
}
