package gae.viewitems;

import gae.Controller;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.util.List;

import javax.swing.Icon;

import model.things.Stat;

public abstract class BoardListViewItem extends ViewItem {
	protected List<Stat> myProperties;
	
	@Override
	public abstract Icon getListIcon();

	@Override
	public abstract String getListMessage();

	@Override
	public abstract List<Stat> getModel();

	@Override
	public void onClick(Controller c) {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void createModel(List<Stat> inputData);

}
