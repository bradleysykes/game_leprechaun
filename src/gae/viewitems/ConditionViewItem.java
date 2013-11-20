package gae.viewitems;


import gae.GUIMap;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Condition;
import model.condition.Create;
import model.stats.Stat;

public class ConditionViewItem extends BoardListViewItem {

	private Condition myCondition;

	public ConditionViewItem(){
		super();
		// initialize this viewitem's list of properties
		myProperties = new ArrayList<Stat>();
	}
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public BoardListViewItem createModel(List<Stat> inputData, String name) {
//		myCondition = new Condition();
//		myCondition.setStats(inputData);
		return new ConditionViewItem();
	}

	@Override
	public String getListMessage() {
		return "Condition List Message";
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}

	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		// TODO Auto-generated method stub
		
	}

}
