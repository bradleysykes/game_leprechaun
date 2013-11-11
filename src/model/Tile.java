package model;

public class Tile {
	
	private Resources myResources;
	private double myPassability;
	private Terrain myTerrain;
	
	public Tile(){
		
	}
	
	public void addResource(Resource newResource){
		myResources.addResource(newResource);
	}

}
