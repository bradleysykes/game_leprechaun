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
import model.things.Stat;

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
	public void createModel(List<Stat> inputData) {
//		myCondition = new Condition();
//		myCondition.setStats(inputData);
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
	public void placeOnBoard(GUIMap map) {
		// TODO Auto-generated method stub
		
	}

}
