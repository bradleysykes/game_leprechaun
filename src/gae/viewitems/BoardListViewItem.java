package gae.viewitems;

import gae.Controller;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.util.List;

import javax.swing.Icon;

import model.things.Thing;

public class BoardListViewItem extends ViewItem {

	@Override
	public Icon getListIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Thing> getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onClick(Controller c) {
		// TODO Auto-generated method stub
		InputDialogue dialogue = new UnitCreationDialogue(getListMessage(),getModel(),c);
	}

}
