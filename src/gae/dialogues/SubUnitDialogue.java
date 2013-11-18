package gae.dialogues;

import gae.panel_lists.BoardList;

import java.util.List;

import model.things.Stat;

public class SubUnitDialogue extends UnitCreationDialogue {

	public SubUnitDialogue(String frameTitle, List<Stat> modelProperties,
			BoardList list) {
		super(frameTitle, modelProperties, list, true);
		
	}
	
	@Override
	public void postInput() {
	 // do nothing
	}

}
