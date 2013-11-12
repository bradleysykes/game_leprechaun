package model.tile;

import java.util.*;

import jgame.JGObject;

import model.ModelConstants;
import model.MyAnnotation;
import model.Resource;
import model.Resources;
import model.Terrain;
import model.unit.Unit;

public class Tile extends JGObject implements ModelConstants{
	
	private Resources myResources = new Resources();
	private double myPassability = DEFAULT_ATTRIBUTE;
	private Terrain myTerrain = new Terrain(DEFAULT_NAME);
	private String myGraphicName = DEFAULT_NAME;
	private Collection<Unit> myUnits = new ArrayList<Unit>();
	// Under the current setup, how are units on the tile being passed when tile is replaced in GAE?
	private int myX = 0;
	private int myY = 0;
	private int myMaxPopulation = (int) DEFAULT_ATTRIBUTE;
	
	public Tile(){
		super("",false,0,0,0,null);
		this.setGraphic(myGraphicName);
	}
	
	public Tile(int x, int y){
		this();
		myX = x;
		myY = y;
	}

	public Tile(@MyAnnotation(name = "Passability", specs = "Number greater than zero") double passability, 
			@MyAnnotation(name = "Max Population on Tile", specs = "Number greater than zero") int maxPop){
		this();
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
		this.setGraphic(myGraphicName);
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
