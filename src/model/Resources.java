package model;

import java.util.ArrayList;
import java.util.List;

public class Resources {
	
	private List<Resource> myResources = new ArrayList<Resource>();
	
	public void addResource(Resource newResource){
		myResources.add(newResource);
	}
	
	public List<Resource> getResources(){
		return myResources;
	}

	public void removeResource(Resource resource) {
		myResources.remove(resource);
	}

}
