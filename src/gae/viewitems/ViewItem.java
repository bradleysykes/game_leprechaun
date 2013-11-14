package gae.viewitems;

import java.util.List;

import gae.Constants;
import gae.UnitCreationDialogue;

import javax.swing.Icon;

import jgame.JGObject;
import jgame.platform.JGEngine;

import model.things.Thing;

public abstract class ViewItem implements Constants {

	public abstract Icon getListIcon();
	
	public abstract String getListMessage();
	
	public abstract List<Thing> getModel();

	public void onClick() {
		// send myProperties to ObjectPanel
		new UnitCreationDialogue(getListMessage(),getModel());
	}
	
	public JGObject placeOnBoard(JGEngine engine){
		//engine.defineImage("unit", "-", 0, imgmap, mapidx, img_op, top, left, width, height)
		//new JGObject(such and such);
		return new JGObject(null, false, 0, 0, 0, null);
	}
}
