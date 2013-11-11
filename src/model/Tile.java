package model;

public class Tile {
	
	private Resources myResources;
	private double myPassability;
	private Terrain myTerrain;
	private String myName;
	
	public Tile(){
		
	}
	
	public void addResource(Resource newResource){
		myResources.addResource(newResource);
	}
	
	public void setImageName(String newImageName){
		myName = newImageName;
	}

}
