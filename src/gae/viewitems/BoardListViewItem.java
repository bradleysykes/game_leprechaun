package gae.viewitems;

import gae.Controller;
import gae.GUIMap;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.util.List;

import javax.swing.Icon;

import model.stats.Stat;

public abstract class BoardListViewItem extends ViewItem {
	protected List<Stat> myProperties;
	
	@Override
	public abstract Icon getListIcon();

	@Override
	public abstract String getListMessage();

	public abstract List<Stat> getModel();
	
	public abstract void placeOnBoard(GUIMap map, double x, double y);

	@Override
	public void onClick(Controller c) {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void createModel(List<Stat> inputData);

}
