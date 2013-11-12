package model.tile;

import java.util.*;

import model.ModelConstants;
import model.MyAnnotation;
import model.Resource;
import model.Resources;
import model.Terrain;
import model.unit.Unit;

public class Tile implements ModelConstants{
	
	private Resources myResources = new Resources();
	private double myPassability;
	private Terrain myTerrain;
	private String myGraphicName;
	private Collection<Unit> myUnits = new ArrayList<Unit>();
	private int myX;
	private int myY;
	private int myMaxPopulation;
	
	public Tile(){
		myPassability = DEFAULT_ATTRIBUTE;
		myTerrain = new Terrain(DEFAULT_NAME);
		myGraphicName = DEFAULT_NAME;
	}

	public Tile(@MyAnnotation(name = "Passability", specs = "Number greater than zero") double passability, 
			@MyAnnotation(name = "Max Population on Tile", specs = "Number greater than zero") int maxPop){
		myPassability = passability;
		myMaxPopulation = maxPop;
	}
	
	public Resource addResource(Resource newResource){
		myResources.addResource(newResource);
		return newResource;
	}
	
	public void removeResource(Resource resource){
		myResources.removeResource(resource);
	}
	
	public List<Resource> getResourcesOnTile(){
		return myResources.getResources();
	}
	
	public String setImageName(String newImageName){
		myGraphicName = newImageName;
		return myGraphicName;
	}
	
	public double getPassability(){
		return myPassability;
	}
	
	public Terrain getTerrain(){
		return myTerrain;
	}
	
	public String getImageName() {
	    return myGraphicName;
	}
	
	public int getX(){
		return myX;
	}
	
	public int getY(){
		return myY;
	}
	
	public boolean addUnit(Unit unit){
		if (myUnits.size() < myMaxPopulation)
			return myUnits.add(unit);
		return false;
	}
	
	public boolean removeUnit(Unit unit){
		return myUnits.remove(unit);
	}
	
	public Collection<Unit> getUnits(){
		return myUnits;
	}
	
	public boolean equals(Tile other){
		return(this.getX()==other.getX() && this.getY()==other.getY());
	}

}
