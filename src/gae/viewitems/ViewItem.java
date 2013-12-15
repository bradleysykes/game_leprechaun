package gae.viewitems;

import gae.Constants;
import gae.control.Controller;
import gae.panel_lists.BoardList;
import javax.swing.Icon;
import javax.swing.JFrame;

/**
 * Abstract class defining elements displayed in BoardList types. Subclass in order to create
 * new types of data to display in the authoring environment.
 * @author Bradley Sykes and William Shelburne
 */

public abstract class ViewItem implements Constants {

	protected Controller myController;
	protected BoardList myListSource;
	protected JFrame myDialogue;

	public abstract Icon getListIcon();
	
	public abstract String getListMessage();
	
	/**
	 * Launch view to allow editing of existing type.
	 */
	public abstract void launchEdit();

	public void onClick(Controller c){
		//default is to do nothing.
	}

	/**Getters and Setters**/
	
	public abstract boolean dialogueActive();
	
	public void setController(Controller controller) {
		myController = controller;
	}

	public void showProperties() {
		//default is to do nothing.
	}
	
	public void setListSource(BoardList boardList) {
		myListSource = boardList;
	}
}
