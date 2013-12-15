package gae.viewitems;

import gae.control.Controller;
import gae.dialogues.InputDialogue;
import gae.dialogues.PlayerDialogue;

public class PlayerTaskViewItem extends TaskViewItem {
	
	private static String myMessage = "Specify number of players";
	private Controller myController;
	private InputDialogue myDialogue;
	
	public PlayerTaskViewItem(Controller controller) {
		super(myMessage, controller);
		myController = controller;
	}
	@Override
	public boolean dialogueActive(){
		return myDialogue!=null;
	}
	
	@Override
	public void onClick(Controller c) {
		myDialogue = new PlayerDialogue(myController);
	}
}
