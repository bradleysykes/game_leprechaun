package gae.viewitems;

import gae.Controller;
import gae.dialogues.InputDialogue;
import gae.dialogues.PlayerDialogue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.stats.Stat;

public class TaskViewItem extends ViewItem {
	
	private String myMessage;
	private Controller myController; // makeshift.  Eclipse won't recognize controller from superclass.
	protected InputDialogue myDialogue;
	public TaskViewItem(String message, Controller controller){
		super();
		myMessage = message;
		myController = controller;
	}
	
	@Override
	public Icon getListIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(ICON_PATH+"task.png");
	}

	@Override
	public String getListMessage() {
		// TODO Auto-generated method stub
		return myMessage;
	}

	@Override
	public void onClick(Controller c) {
		// TODO Auto-generated method stub
	}

}
