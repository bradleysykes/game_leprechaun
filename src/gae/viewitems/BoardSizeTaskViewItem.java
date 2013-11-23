package gae.viewitems;

import gae.Controller;
import gae.dialogues.BoardSizeDialogue;
import gae.dialogues.InputDialogue;

public class BoardSizeTaskViewItem extends TaskViewItem {
	private static String myMessage = "Select Board Size";
	private Controller myController;
	
	public BoardSizeTaskViewItem(Controller controller) {
		super(myMessage, controller);
		myController = controller;
	}
	
	@Override
	public boolean dialogueActive(){
		return myDialogue!=null;
	}

	@Override
	public void onClick(Controller c) {
		myDialogue = new BoardSizeDialogue(myController);
	}

}
