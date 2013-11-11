package model;

import java.util.List;

public class Tile {
	
	private Resources myResources;
	private double myPassability;
	private Terrain myTerrain;
	private String myName;

	public Tile(Resources resources, double passability, Terrain terrain, String name){
		myResources = resources;
		myPassability = passability;
		myTerrain = terrain;
		myName = name;
	}  
	
	public void addResource(Resource newResource){
		myResources.addResource(newResource);
	}
	
	public List<Resource> getResourcesOnTile(){
		return myResources.getResources();
	}
	
	public void setImageName(String newImageName){
		myName = newImageName;
	}
	
	//Added the following methods for data (Alex)
	public String getImageName() {
	    return myName;
	}
	
	public double getPassability() {
	    return myPassability;
	}
	
	public Terrain getTerrain() {
	    return myTerrain;
	}
	
	

}
