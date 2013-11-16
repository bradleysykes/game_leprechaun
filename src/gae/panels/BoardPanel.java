package gae.panels;

import gae.Controller;
import gae.EditTabbedView;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTabbedPane;

import model.Player;
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

}
