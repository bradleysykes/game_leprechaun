package engine.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StatusArea extends JPanel {
	
	protected JScrollPane myScrollPane;
	protected JTextArea myStatusArea;
	private final Dimension mySize = new Dimension(230, 180);
	
	public StatusArea() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		myStatusArea = new JTextArea();
		myStatusArea.setPreferredSize(null);
		myStatusArea.setBackground(Color.black);
		myStatusArea.setForeground(Color.green);
		myStatusArea.setCaretColor(Color.green);
		myStatusArea.setEditable(false);
		
		myScrollPane = new JScrollPane(myStatusArea);
		myScrollPane.setPreferredSize(mySize);
		
		add(myScrollPane);
	}
	
}