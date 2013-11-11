package model;

import java.util.ArrayList;

public class GameMap {
	
	private ArrayList<ArrayList<Tile>> myTiles;
	
	public GameMap(){
		
	}
	
	public Tile getTile(int x, int y){
		return myTiles.get(x).get(y);
	}
	
	public void addResourceToTile(int x, int y, String resourceName, double amount, double harvestRate){
		this.getTile(x,y).addResource(new Resource(resourceName,amount,harvestRate));
	}
	
	public void setTileImageName(int x, int y, String newImageName){
		this.getTile(x,y).setImageName(newImageName);
	}

	public Unit getTarget(int initialX, int initialY, int range){
		/* provide the player with a fixed number of tile choices
		 * and returns a selected unit
		 */
		return null;
	}

}
