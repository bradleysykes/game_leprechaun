package gae.viewitems;

import java.io.File;
import java.util.List;

import gae.Controller;
import gae.GUIMap;

import javax.swing.Icon;

import model.GameMap;
import model.stats.Stat;
import model.tile.Tile;

public class AbilityViewItem extends BoardListViewItem {

	public AbilityViewItem() {
		super(DEFAULT_ABILITY_IMAGE_PATH);
	}
	
	public AbilityViewItem(List<Stat> stats,String name, File f, int counter){
		super(stats, name, f);
		//create the ability?
	}

	@Override
	public Icon getListIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onClick(Controller c) {
		// TODO Auto-generated method stub
	}

	@Override
	protected String getMapPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getResizeDimensions() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	protected String getDefaultImagePath() {
		return DEFAULT_ABILITY_IMAGE_PATH;
	}

	@Override
	public List<Stat> getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void clickOnBoard(GUIMap map, double x, double y,
			PlayerViewItem activePlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardListViewItem createModel(List<Stat> inputData, String name,
			File imageFile, int myCounter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getModelObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
