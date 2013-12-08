package model;

import java.util.ArrayList;
import java.util.List;

import model.stats.Stat;
import model.stats.StatCollection;

public class Resources extends StatCollection {
	
	public Resources() {
		super("Resources");
	}
	
	public Resources(Resources r){
		this();
		for(Resource resource : r.getResources()){
			this.addResource((Resource) resource.copy());
		}
	}
	
	public void addResource(Resource resource){
		this.addStat(resource);
	}

	public void removeResource(Resource resource) {
		this.removeStat(resource);
	}
	
	public List<Resource> getResources(){
		List<Resource> toReturn = new ArrayList<Resource>();
		for(Stat s : this.getStats())
			toReturn.add((Resource) s);
		return toReturn;
	}

}
