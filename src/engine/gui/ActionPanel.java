package engine.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ActionPanel extends JPanel {
	
	private Dimension mySize = new Dimension(250, 230);
	private JButton myNextTurnButton;
	private JPanel myUnitListArea;
	private JPanel myAbilityListArea;
	
	public ActionPanel() {
		setPreferredSize(mySize);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Actions");
		titledBorder.setTitleJustification(TitledBorder.LEFT);
		setBorder(titledBorder);
		
		myNextTurnButton = new NextTurnButton();
		myUnitListArea = new UnitListArea();
		myAbilityListArea = new AbilityListArea();
		
		add(myNextTurnButton);
		add(myUnitListArea);
		add(myAbilityListArea);
	}
	
	public JPanel getUnitListArea() {
		return myUnitListArea;
	}
	
	public JPanel getAbilityListArea() {
		return myAbilityListArea;
	}
	
}
