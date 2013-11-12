package model;

import java.util.*;


public class Tile implements ModelConstants{
	
	private Resources myResources = new Resources();
	private double myPassability;
	private Terrain myTerrain;
	private String myName;
	private Collection<Unit> myUnits = new ArrayList<Unit>();
	private int maxPopulation;
	
	public Tile(){
		
	}

	public Tile(Resources resources, double passability, Terrain terrain, String name){
		myResources = resources;
		myPassability = passability;
		myTerrain = terrain;
		myName = name;
		maxPopulation = DEFAULT_MAX_POPULATION;
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
	
	//Added the following methods for data (Alex)
	public String getImageName() {
	    return myName;
	}
	
	public boolean addUnit(Unit unit){
		if (myUnits.size() < maxPopulation)
			return myUnits.add(unit);
		return false;
	}
	
	public boolean removeUnit(Unit unit){
		return myUnits.remove(unit);
	}
	
	public Collection<Unit> getUnits(){
		return myUnits;
	}

}
