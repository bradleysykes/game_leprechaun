package gae.panels;


import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ObjectPanel extends EditPanel {
	
	public ObjectPanel(){
		super();
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("YOLO");
		JList<String> objectList = new JList<String>(model);
		this.add(objectList);
		initialize(objectList);
	}

}