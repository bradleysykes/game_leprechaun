package model;

import model.stats.StatCollection;

public class Resources extends StatCollection {
	
	public Resources() {
		super("Resources");
	}
	
	public void addResource(Resource resource){
		this.addStat(resource);
	}

	public void removeResource(Resource resource) {
		this.removeStat(resource);
	}

}
