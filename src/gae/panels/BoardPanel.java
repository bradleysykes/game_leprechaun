package gae.panels;

import gae.Controller;
import gae.EditTabbedView;
import gae.panel_lists.BoardList;
import gae.panel_lists.ConditionList;
import gae.panel_lists.ResourceList;
import gae.panel_lists.TileList;
import gae.panel_lists.UnitList;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTabbedPane;

import data.GameElements;
import model.Player;
import model.unit.Unit;



public class BoardPanel extends EditPanel {
	
	private EditTabbedView myTabbedPane;
	
	public BoardPanel(Controller controller){
		super(controller);
		BoardList[] tabs = {new ConditionList(controller), new ResourceList(controller), 
				new TileList(controller), new UnitList(controller)};
		myTabbedPane = new EditTabbedView(tabs,controller);
		this.add(myTabbedPane);
		initialize(myTabbedPane);
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return BOARD_PANEL_TITLE;
	}
	
	@Override
	public GameElements giveStateObjects(GameElements currentState) {
			return myTabbedPane.giveStateObjects(currentState);
	}
	
	@Override
	public List<Unit> getUnitTypes() {
		return myTabbedPane.getUnitTypes();
	}
	
	@Override
	public void loadData(GameElements elements) {
		myTabbedPane.loadData(elements);
	}

}
