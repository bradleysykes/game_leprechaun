package gae.panel_lists;

import gae.control.Controller;
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
	@Deprecated
	public String getPackageName() {
		return null;
	}
	
	@Override
	public String getDefaultName(){
		return "Default Resource Name";
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
		ResourceViewItem rvi = new ResourceViewItem(inputData,name,f);
		myController.addResourceToPlayers(rvi.getModelObject());
		return rvi;
	}
	
	@Override 
	public void loadData(GameElements elements){
			
	}

}
