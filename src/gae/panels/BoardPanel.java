package gae.panels;

import gae.Controller;
import gae.EditTabbedView;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;


public class BoardPanel extends EditPanel {
	private JTabbedPane myTabbedPane;
	public BoardPanel(Controller controller){
		super(controller);
		String[] tabs = {"Objects","Tiles","Conditions"};
		myTabbedPane = new EditTabbedView(tabs);
		this.add(myTabbedPane);
		initialize(myTabbedPane);
	}

}
