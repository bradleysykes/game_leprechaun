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
	//private JPanel myTileStatusArea;
	private final Dimension mySize = new Dimension(500, 230);
	
	public FeedbackPanel() {
		setPreferredSize(mySize);
		setLayout(new FlowLayout());
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Game Info");
		setBorder(titledBorder);
		
		myUnitStatusArea = new StatusArea("UNIT STATS");
		myPlayerStatusArea = new StatusArea("PLAYER STATS");
		//myTileStatusArea = new StatusArea("TILE STATS");
		
		add(myUnitStatusArea);
		//add(myTileStatusArea);
		add(myPlayerStatusArea);
	}
	
	public StatusArea getUnitStatusArea() {
		return (StatusArea) myUnitStatusArea;
	}
	
	public StatusArea getPlayerStatusArea() {
		return (StatusArea) myPlayerStatusArea;
	}
	
//	public StatusArea getTileStatusArea() {
//		return (StatusArea) myTileStatusArea;
//	}
	
}
