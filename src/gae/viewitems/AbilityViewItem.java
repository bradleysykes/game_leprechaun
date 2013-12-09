package gae.viewitems;

import java.io.File;
import java.util.List;

import gae.Controller;
import gae.GUIMap;

import javax.swing.Icon;

import model.GameMap;
import model.abilities.CustomAbility;
import model.stats.Stat;
import model.tile.Tile;

public class AbilityViewItem extends BoardListViewItem {
	
	private CustomAbility myAbility;

	public AbilityViewItem() {
		super(DEFAULT_ABILITY_IMAGE_PATH);
	}
	
	@SuppressWarnings("unchecked")
	public AbilityViewItem(List<Stat> stats,String name, File f, int counter){
		super(stats, name, f);
		double range = 0, radius = 0;
		for(Stat s : stats){
			if (s.getName().equals("Range")){
				range = s.getValue();
			}
			if (s.getName().equals("Radius")){
				radius = s.getValue();
			}
		}
		myAbility = new CustomAbility(name, null, range, radius);
	}

	@Override
	public String getListMessage() {
		return myName;
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
		return myProperties;
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
	public CustomAbility getModelObject() {
		return myAbility;
	}

}
