package gae.panel_lists;

import gae.Controller;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ResourceViewItem;

import java.io.File;
import java.util.List;

import data.GameElements;

import model.Resource;
import model.stats.Stat;

public class ResourceList extends BoardList {

	public ResourceList(Controller controller) {
		super(controller);
	}

	@Override
	public String getPackageName() {
		return null;
	}
	
	@Override
	public List<Stat> getDefaultStats(){
		return new Resource(DEFAULT_RESOURCE_PATH, 0, 0).getStats();
	}

	@Override
	public String getListType() {
		return "Resources";
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f, int counter) {
		
		return new ResourceViewItem(inputData,name,f);
	}
	
	@Override 
	public void loadData(GameElements elements){
			
	}

}
