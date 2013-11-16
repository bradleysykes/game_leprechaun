package gae.viewitems;


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

	
	@Override
	public List<Stat> getModel() {
		return new ArrayList<Stat>();
	}

}
