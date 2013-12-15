package gae.viewitems;


import gae.dialogues.ConditionDialogue;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;
import gae.map.GUIMap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Condition;
import model.condition.Create;
import model.stats.Stat;
import model.*;

public class ConditionViewItem extends BoardListViewItem {

	private Condition myCondition;

	public ConditionViewItem(String name, Condition condition){
		super(new ArrayList<Stat>(), name ,new File(DEFAULT_CONDITION_PATH));
		myCondition = condition;
		// initialize this viewitem's list of properties
		myProperties = new ArrayList<Stat>();
	}	
	
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

//	@Override
//	public BoardListViewItem createModel(List<Stat> inputData, String name, 
//			File imageFile, int counter) {
//		myController.getPlayers();
//		myCondition = new Create(null, null);
//		myCondition.setStats(inputData);
//		return new ConditionViewItem("Test Name", null);
//	}

	@Override
	public String getListMessage() {
		return myName;
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(myImagePath);
	}

	@Override
	protected int getResizeDimensions() {
		return CONDITION_IMAGE_RESIZE;
	}

	@Override
	protected String getDefaultImagePath() {
		return DEFAULT_UNIT_PATH;
	}

	@Override
	protected String getMapPrefix() {
		return "";
	}

	@Override
	public Condition getModelObject() {
		return myCondition;
	}

	

}
