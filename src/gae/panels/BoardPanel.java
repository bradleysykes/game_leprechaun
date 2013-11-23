package gae.panels;

import gae.Controller;
import gae.EditTabbedView;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTabbedPane;

import model.Player;



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
	public String getTitle() {
		// TODO Auto-generated method stub
		return BOARD_PANEL_TITLE;
	}

}
