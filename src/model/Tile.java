package model;

import java.util.List;

public class Tile {
	
	private Resources myResources = new Resources();
	private double myPassability;
	private Terrain myTerrain;
	private String myName;
	
	public Tile(){
		
	}
	
	public Resource addResource(Resource newResource){
		myResources.addResource(newResource);
		return newResource;
	}
	
	public List<Resource> getResourcesOnTile(){
		return myResources.getResources();
	}
	
	public String setImageName(String newImageName){
		myName = newImageName;
		return myName;
	}
	
	public double getPassability(){
		return myPassability;
	}
	
	public Terrain getTerrain(){
		return myTerrain;
	}

}
