package engine.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FeedbackPanel extends JPanel {
	
	private JPanel myUnitStatusArea;
	private JPanel myPlayerStatusArea;
	private final Dimension mySize = new Dimension(500, 230);
	
	public FeedbackPanel() {
		setPreferredSize(mySize);
		setLayout(new FlowLayout());
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Game Info");
		setBorder(titledBorder);
		
		myUnitStatusArea = new UnitStatusArea();
		myPlayerStatusArea = new PlayerStatusArea();
		
		add(myUnitStatusArea);
		add(myPlayerStatusArea);
	}
	
	public JPanel getUnitStatusArea() {
		return myUnitStatusArea;
	}
	
	public JPanel getPlayerStatusArea() {
		return myPlayerStatusArea;
	}
	
}
