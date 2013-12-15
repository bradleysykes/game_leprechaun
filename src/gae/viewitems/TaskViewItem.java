package gae.viewitems;

import gae.control.Controller;
import gae.dialogues.InputDialogue;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Abstract class used as an authoring environment representation of a discrete task that must be accomplished
 * before the game can be saved. Displayed in TaskPanel and TaskList. Extends ViewItem.
 * @author Bradley Sykes and William Shelburne
 */

public class TaskViewItem extends ViewItem {
	
	private String myMessage;
	protected InputDialogue myDialogue;
	
	public TaskViewItem(String message, Controller controller){
		myMessage = message;
		myController = controller;
	}
	
	@Override
	public Icon getListIcon() {
		return new ImageIcon(ICON_PATH+TASK_ICON_PATH);
	}

	@Override
	public String getListMessage() {
		return myMessage;
	}

	@Override
	public void launchEdit() {
		//do nothing.
	}
	
	@Override
	public boolean dialogueActive(){
		return myDialogue!=null;
	}

}
