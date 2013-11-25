package gae.viewitems;


import gae.GUIMap;
import gae.dialogues.ConditionDialogue;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

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
		super(name);
		myCondition = condition;
		// initialize this viewitem's list of properties
		myProperties = new ArrayList<Stat>();
	}
	
	public ConditionViewItem(){
		this("test condition", null);
	}
	
	
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public BoardListViewItem createModel(List<Stat> inputData, String name, 
			File imageFile, int counter) {
		myController.getPlayers();
		myCondition = new Create(null, null);
		myCondition.setStats(inputData);
		return new ConditionViewItem("Test Name", null);
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}

	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickOnBoard(GUIMap map, double x, double y, PlayerViewItem player) {
		// to do 
	}

	@Override
	protected int getResizeDimensions() {
		return 0;
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
	public List<Stat> getDefaults() {
		return null;
	}

	public Object getModelObject() {
		return myCondition;
	}

}
