package gae;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;


public class BoardPanel extends EditPanel {
	private JTabbedPane myTabbedPane;
	public BoardPanel(){
		super();
		String[] tabs = {"Objects","Tiles","Conditions"};
		myTabbedPane = new EditTabbedView(tabs);
		this.add(myTabbedPane);
		initialize(myTabbedPane);
	}
}
