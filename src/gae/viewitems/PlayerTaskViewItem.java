package gae.viewitems;

import gae.Controller;
import gae.dialogues.PlayerDialogue;

public class PlayerTaskViewItem extends TaskViewItem {
	private static String myMessage = "Specify number of players";
	private Controller myController;
	public PlayerTaskViewItem(Controller controller) {
		super(myMessage, controller);
		myController = controller;
	}
	
	@Override
	public void onClick() {
		PlayerDialogue p = new PlayerDialogue(myController);
	}
}
