package gae.viewitems;

import java.util.List;

import gae.Constants;
import gae.Controller;
import gae.dialogues.UnitCreationDialogue;

import javax.swing.Icon;

import model.stats.Stat;

import jgame.JGObject;
import jgame.platform.JGEngine;


public abstract class ViewItem implements Constants {

	private Controller myController;

	public abstract Icon getListIcon();
	
	public abstract String getListMessage();

	public abstract void onClick(Controller c);
	
	public void setController(Controller controller) {
		myController = controller;
	}
}
