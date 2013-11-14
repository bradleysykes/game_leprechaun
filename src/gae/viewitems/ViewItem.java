package gae.viewitems;

import java.util.List;

import gae.Constants;
import gae.UnitCreationDialogue;

import javax.swing.Icon;

import model.things.Thing;

public abstract class ViewItem implements Constants {

	public abstract Icon getListIcon();
	
	public abstract String getListMessage();
	
	public abstract List<Thing> getModel();

	public void onClick() {
		String s = getListMessage();
		List<Thing> things = getModel();
		new UnitCreationDialogue(getListMessage(),getModel());
	}
}
