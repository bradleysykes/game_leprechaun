package gae.panels;

import gae.Controller;
import gae.EditTabbedView;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTabbedPane;

import model.things.Thing;


public class BoardPanel extends EditPanel {
	private JTabbedPane myTabbedPane;
	public BoardPanel(Controller controller){
		super(controller);
		String[] tabs = {"Objects","Tiles","Conditions"};
		myTabbedPane = new EditTabbedView(tabs, controller);
		this.add(myTabbedPane);
		initialize(myTabbedPane);
	}
	
	@Override
	public void postProperties(List<Thing> properties) {
		// TODO Auto-generated method stub
		
	}

}
