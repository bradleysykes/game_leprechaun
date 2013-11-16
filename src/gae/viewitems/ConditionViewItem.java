package gae.viewitems;


import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Condition;
import model.condition.Create;
import model.things.Thing;

public class ConditionViewItem extends BoardListViewItem {

	

	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+"plus.gif");
	}

	@Override
	public String getListMessage() {
		return "Create new victory condition";
	}

	@Override
	public List<Thing> getModel() {
		return new ArrayList<Thing>();
	}

}
