package model;

import java.util.*;

public class GameMap {

	private List<List<Tile>> myTiles = new ArrayList<List<Tile>>();

	public GameMap(int x, int y){
		for(int i = 0; i < x; i++){
			myTiles.add(new ArrayList<Tile>());
			for(int q = 0; q < y; q++){
				myTiles.get(i).add(new Tile());
				// Create default tile to populate map on startup.
			}
		}
	}

	public boolean contains(int x, int y){
		if(myTiles.get(x)!=null){
			if(myTiles.get(x).get(y)!=null){
				return true;
			}
		}
		return false;
	}

	public Tile getTile(int x, int y){
		return myTiles.get(x).get(y);
	}

	public Collection<Tile> getAllTiles(){
		Collection<Tile> allTiles = new ArrayList<Tile>();
		for (List<Tile> tiles : myTiles){
			for (Tile tile : tiles){
				allTiles.add(tile);
			}
		}
		return allTiles;
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
