package gae.viewitems;

import java.util.List;

import gae.Constants;
import gae.Controller;
import gae.dialogues.UnitCreationDialogue;

import javax.swing.Icon;

import model.things.Stat;

import jgame.JGObject;
import jgame.platform.JGEngine;


public abstract class ViewItem implements Constants {

	private Controller myController;

	public abstract Icon getListIcon();
	
	public abstract String getListMessage();
	
	public abstract List<Stat> getModel();

	public abstract void onClick(Controller c);
	
	public JGObject placeOnBoard(JGEngine engine){
		//engine.defineImage("unit", "-", 0, imgmap, mapidx, img_op, top, left, width, height)
		//new JGObject(such and such);
		return new JGObject(null, false, 0, 0, 0, null);
	}

	public void setController(Controller controller) {
		myController = controller;
	}
}
