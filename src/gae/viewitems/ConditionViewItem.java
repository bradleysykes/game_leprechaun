package gae.viewitems;


import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.condition.Condition;
import model.condition.Create;
import model.things.Thing;

public class ConditionViewItem extends BoardListViewItem {

	
	@Override
	public List<Thing> getModel() {
		return new ArrayList<Thing>();
	}

}
