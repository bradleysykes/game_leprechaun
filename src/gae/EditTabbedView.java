package gae;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class EditTabbedView extends JTabbedPane {
	
	private Map<String,JList> myTabContents = new HashMap<String,JList>();
	
	public EditTabbedView(String[] tabs){
		myTabContents.put("Units", new UnitList());
		myTabContents.put("Tiles", new UnitList());
		myTabContents.put("Conditions", new UnitList());
		for(String tab : myTabContents.keySet()){
			JScrollPane scroll = new JScrollPane(myTabContents.get(tab));
			this.addTab(tab, scroll);
		}
	}
}
