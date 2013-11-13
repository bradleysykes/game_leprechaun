package model.tile;

import gae.BoardListItem;

import java.util.*;

import jgame.JGObject;

import model.ModelConstants;
import model.MyAnnotation;
import model.Resource;
import model.Resources;
import model.Terrain;
import model.unit.Unit;

public class Tile extends JGObject implements ModelConstants, BoardListItem{
	
	private Resources myResources = new Resources();
	private double myPassability = DEFAULT_ATTRIBUTE;
	private Terrain myTerrain = new Terrain(DEFAULT_NAME);
	private String myGraphicName = DEFAULT_NAME;
	private Collection<Unit> myUnits = new ArrayList<Unit>();
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
	
	public Tile(Resources resources, double passability, Terrain terrain, String name,
			Collection<Unit> units, int population, int x, int y){
		super("",false,0,0,0,null);
		myResources = resources;
		myPassability = passability;
		myTerrain = terrain;
		myGraphicName = name;
		myUnits = units;
		myMaxPopulation = population;
		myX = x;
		myY = y;
	}

	public Tile(@MyAnnotation(name = "Passability", specs = "Number greater than zero") double passability, 
			@MyAnnotation(name = "Max Population on Tile", specs = "Number greater than zero") int maxPop){
		this();
		myPassability = passability;
		myMaxPopulation = maxPop;
	}
	
	public boolean addUnit(Unit unit){
		if (myUnits.size() < myMaxPopulation)
			return myUnits.add(unit);
		return false;
	}
	
	public boolean removeUnit(Unit unit){
		return myUnits.remove(unit);
	}
	
	public boolean equals(Tile other){
		return(this.getX()==other.getX() && this.getY()==other.getY());
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
	
	// GETTERS AND SETTERS for every instance variable as requested by Data team.
	
	public void setUnits(Collection<Unit> u){
		myUnits = u;
	}
	
	public Collection<Unit> getUnits(){
		return myUnits;
	}
	
	public void setResources(Resources r){
		myResources = r;
	}
	
	public Resources getResources(){
		return myResources;
	}
	
	public void setPassability(double p){
		myPassability = p;
	}
	
	public double getPassability(){
		return myPassability;
	}
	
	public void setTerrain(Terrain t){
		myTerrain = t;
	}
	
	public Terrain getTerrain(){
		return myTerrain;
	}
	
	public String setImageName(String newImageName){
		myGraphicName = newImageName;
		this.setGraphic(myGraphicName);
		return myGraphicName;
	}
	
	public String getImageName() {
	    return myGraphicName;
	}
	
	public void setX(int x){
		myX = x;
	}
	
	public int getX(){
		return myX;
	}
	
	public void setY(int y){
		myY = y;
	}
	
	public int getY(){
		return myY;
	}
	
	public void setMaxPop(int p){
		myMaxPopulation = p;
	}
	
	public int getMaxPop(){
		return myMaxPopulation;
	}

	@Override
	public String getRelativeImagePath() {
		// TODO Auto-generated method stub
		return System.getProperty("user.dir")+"\\gae\\resources\\test_tile.jpg";
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return System.getProperty("user.dir")+"\\gae\\resources\\test_tile.jpg";
	}

	@Override
	public String getObjectClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
