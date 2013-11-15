package model;

import model.things.ThingsThing;

public class Resources extends ThingsThing {
	
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
