package gae.viewitems;

import gae.Controller;
import gae.dialogues.BoardSizeDialogue;

public class BoardSizeTaskViewItem extends TaskViewItem {
	private static String myMessage = "Select Board Size";
	private Controller myController;
	
	public BoardSizeTaskViewItem(Controller controller) {
		super(myMessage, controller);
		myController = controller;
	}

	@Override
	public void onClick() {
		BoardSizeDialogue d = new BoardSizeDialogue(myController);
	}

}
