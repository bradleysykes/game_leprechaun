package gae;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ObjectPanel extends EditPanel {
	
	public ObjectPanel(){
		this.setBackground(Color.PINK);
		JTextArea myTextArea = new JTextArea("Object Properties");
		this.add(myTextArea);
		initialize(myTextArea);
	}
}
