package gae.viewitems;

import gae.dialogues.PlayerDialogue;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.things.Thing;

public class TaskViewItem extends ViewItem {

	@Override
	public Icon getListIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(ICON_PATH+"task.png");
	}

	@Override
	public String getListMessage() {
		// TODO Auto-generated method stub
		return "Task";
	}

	@Override
	public List<Thing> getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onClick() {
		PlayerDialogue p = new PlayerDialogue();
	}

}
