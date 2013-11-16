package model;

import model.things.StatCollection;

public class Resources extends StatCollection {
	
	public Resources() {
		super("Resources", "Thing");
	}
	
	public void addResource(Resource newResource){
		this.addThing(newResource);
	}

	public void removeResource(Resource resource) {
		this.removeThing(resource);
	}

}
