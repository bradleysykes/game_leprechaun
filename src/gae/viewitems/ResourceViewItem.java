package gae.viewitems;

import gae.GUIMap;

import java.io.File;
import java.util.List;

import model.Resource;
import model.Resources;
import model.stats.Stat;



public class ResourceViewItem extends BoardListViewItem {

	private Resources myResource;

	public ResourceViewItem(List<Stat> stats, String name, File imageFile) {
		super(stats, name, imageFile);
		myResource = new Resources();
		myDefaults = myResource.getStats();
		myResource.setStats(stats);
	}

	@Override
	protected String getMapPrefix() {
		return myMapObjectPrefix;
	}

	@Override
	protected int getResizeDimensions() {
		return RESOURCE_IMAGE_RESIZE;
	}

	@Override
	protected String getDefaultImagePath() {
		return DEFAULT_RESOURCE_PATH;
	}

	@Override
	public String getListMessage() {
		return myResource.getName();
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
	public BoardListViewItem createModel(List<Stat> inputData, String name,
			File imageFile, int myCounter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getModelObject() {
		return myResource;
	}

}
