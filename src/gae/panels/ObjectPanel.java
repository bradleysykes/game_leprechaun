package gae.panels;


import gae.Controller;

import java.awt.Color;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.things.Thing;

public class ObjectPanel extends EditPanel {
	
	private JList<Thing> myList;
	private DefaultListModel<Thing> myModel;

	public ObjectPanel(Controller controller){
		super(controller);
		myModel = new DefaultListModel<Thing>();
		myList = new JList<Thing>(myModel);
		this.add(myList);
		initialize(myList);
	}

	@Override
	public void postProperties(List<Thing> properties) {
		// send to list
		for(Thing t:properties){
			System.out.println("burn the roof");
			myModel.addElement(t);
		}
	}

}
