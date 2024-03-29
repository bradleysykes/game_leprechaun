package gae.viewitems;

import gae.control.Controller;
import gae.dialogues.BoardSizeDialogue;

public class BoardSizeTaskViewItem extends TaskViewItem {
	private static String myMessage = "Select Board Size";
	private Controller myController;
	
	public BoardSizeTaskViewItem(Controller controller) {
		super(myMessage, controller);
		myController = controller;
	}

	@Override
	public void onClick(Controller c) {
		myDialogue = new BoardSizeDialogue(myController);
	}

}
