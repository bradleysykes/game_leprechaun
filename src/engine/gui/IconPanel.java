package engine.gui;

import java.awt.Dimension;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconPanel extends JPanel {
	
	private final Dimension mySize = new Dimension(40, 40);
	private ImageIcon myImageIcon;
	
	public IconPanel() {
		myImageIcon = null;
		this.setSize(mySize);
		setAlignmentY(0.5f);
		add(new JLabel("", myImageIcon, JLabel.CENTER));
	}
	
	public void setIcon(String imagePath) {
		myImageIcon = new ImageIcon(imagePath);
	}
	
}
