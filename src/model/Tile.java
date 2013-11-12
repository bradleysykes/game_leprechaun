package model;

import java.util.List;

public class Tile implements ModelConstants{
	
	private Resources myResources = new Resources();
	private double myPassability;
	private Terrain myTerrain;
	private String myGraphicName;
	private int myX;
	private int myY;
	
	public Tile(){
		myPassability = DEFAULT_ATTRIBUTE;
		myTerrain = new Terrain(DEFAULT_NAME);
		myGraphicName = DEFAULT_NAME;
	}

	public Tile(@MyAnnotation(name = "Passability", specs = "Number greater than zero") double passability, 
			@MyAnnotation(name = "Terrain Type", specs = "Name of terrain") String terrain, 
			@MyAnnotation(name = "Graphic Name", specs = "Name of tile's graphic") String graphicName){
		myPassability = passability;
		myTerrain = new Terrain(terrain);
		myGraphicName = graphicName;
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
	

}
