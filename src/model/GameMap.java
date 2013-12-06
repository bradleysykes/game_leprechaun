package model;

import java.util.*;

import model.tile.Tile;
import model.unit.Unit;

public class GameMap {

	private List<List<Tile>> myTiles = new ArrayList<List<Tile>>();
	
	public GameMap(int x, int y){
		for(int i = 0; i < x; i++){
			myTiles.add(new ArrayList<Tile>());
			for(int q = 0; q < y; q++){
				myTiles.get(i).add(new Tile(i,q,this));
				// Create default tile to populate map on startup.
			}
		}
	}
	
	public void setTile(int x, int y, Tile t){
		List<Tile> tileRow = myTiles.get(x);
		tileRow.set(y, t);
	}
	
	public void clearTiles(){
		myTiles.clear();
	}

	public boolean contains(int x, int y){
/*		if(myTiles.size() < x || myTiles.get(0).size() < y || x < 0 || y < 0)
			return false;
		if(myTiles.get(x)!=null){
			if(myTiles.get(x).get(y)!=null){
				return true;
			}
		}
		return false;*/
		if(x < 0 || y < 0)
			return false;
		if(myTiles.size() <= x)
			return false;
		if(myTiles.get(x).size() <= y)
			return false;
		return true;
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

//	public void addResourceToTile(int x, int y, String resourceName, double amount, double harvestRate){
//		this.getTile(x,y).addResource(new Resource(resourceName,amount,harvestRate));
//	}

	public Unit getTargetUnit(List<Tile> validTiles){
		/* provide the player with a fixed number of tile choices
		 * and returns a selected unit
		 */
		return null;
	}
	
	public Tile getTargetTile(List<Tile> validTiles){
		// Get selected tile from game engine.
		return null;
	}
	
	public double checkUnitCount(String unitID, String playerID){
		double count = 0.0;
		for(Tile t : this.getAllTiles()){
			for(Unit u : t.getUnits()){
				if(u.getID().equals(unitID) && u.getPlayer().getID().equals(playerID)){
					count++;
				}
			}
		}
		return count;
	}
	
	public List<Tile> getTilesInRadius(double r, Tile t){
		int range = (int) r;
		List<Tile> validTiles = new ArrayList<Tile>();
		for (int i = t.getX() - range; i <= t.getX() + range; i++){
			for (int j = t.getY() - range; j <= t.getY() + range; j++){
				if(this.contains(i, j))
					validTiles.add(this.getTile(i, j));
			}
		}
		return validTiles;
	}
	
	public Tile getNearestValidTile(Unit u){
		List<Tile> possible = getTilesInRadius(1,u.getCurrentTile());
		for(Tile t : possible){
			if(!t.isOccupiedByOpponent(u.getPlayer()))
					return t;
		}
		return u.getCurrentTile();		
	}
	
	public int getSizeX() {
		return myTiles.get(0).size();
	}
	
	public int getSizeY() {
		return myTiles.size();
	}

}
