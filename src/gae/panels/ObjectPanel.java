package gae.panels;


import gae.Controller;
import gae.viewitems.ViewItem;

import java.awt.Color;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Player;
import model.things.Stat;

public class ObjectPanel extends EditPanel {
	
	private JList<Stat> myList;
	private DefaultListModel<Stat> myModel;

	public ObjectPanel(Controller controller){
		super(controller);
		myModel = new DefaultListModel<Stat>();
		myList = new JList<Stat>(myModel);
		this.add(myList);
		initialize(myList);
	}

	@Override
	public void postProperties(List<Stat> properties) {
		// send to list
//		for(int x=0;x<12;x++){
//			Thing t = new DoubleThing("Cheese");
//			myModel.addElement(new DoubleThing(t.getName()+ "---"+t.getField()));
//		}
		for(Stat t:properties){
			//waiting for model to fill ThingList
			myModel.addElement(t);
		}
	}

}
