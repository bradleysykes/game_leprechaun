package gae;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class EditTabbedView extends JTabbedPane {
	
	public EditTabbedView(String[] tabs){
		for(String tab : tabs){
			Dimension min = new Dimension(400,400);
			JTextArea text = new JTextArea(tab);
			text.setMinimumSize(min);
			JScrollPane scroll = new JScrollPane(text);
			scroll.setMinimumSize(min);
			this.addTab(tab, scroll);
		}
	}
}
