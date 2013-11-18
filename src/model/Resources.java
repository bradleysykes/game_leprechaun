package model;

import model.stats.StatCollection;

public class Resources extends StatCollection {
	
	public Resources() {
		super("Resources");
	}
	
	public void addResource(Resource newResource){
		this.addStat(newResource);
	}

	public void removeResource(Resource resource) {
		this.removeStat(resource);
	}

}
