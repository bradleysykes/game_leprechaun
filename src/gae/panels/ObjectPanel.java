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
import model.things.DoubleThing;
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
		for(int x=0;x<12;x++){
			Thing t = new DoubleThing("Cheese");
			myModel.addElement(new DoubleThing(t.getName()+ "---"+t.getField()));
		}
		for(Thing t:properties){
			//waiting for model to fill ThingList
			//myModel.addElement(t);
		}
	}

	@Override
	public void postPlayers(List<Player> myPlayers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addViewItem(ViewItem item) {
		// TODO Auto-generated method stub
		
	}

}
