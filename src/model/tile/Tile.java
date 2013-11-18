package model.tile;

import java.util.*;

import model.GameMap;
import model.ModelConstants;
import model.Resources;
import model.Terrain;
import model.things.Stat;
import model.things.StatCollection;
import model.unit.Unit;

public class Tile extends StatCollection implements ModelConstants{
	
	private List<Unit> myUnits = new ArrayList<Unit>();
	private GameMap myMap;
	
	public Tile(double x, double y, GameMap map){
		super("Tile");
		myMap = map;
		this.addStat(new Stat("x",x));
		this.addStat(new Stat("y",y));
		this.addStat(new Stat("Passability"));
		this.addStat(new Stat("Max Population"));
		this.addStat(new Resources());
		this.addStat(new Terrain());
	}
	
	public boolean addUnit(Unit unit){
		if (myUnits.size() < this.getValue("Max Population"))
			return myUnits.add(unit);
		return false;
	}
	
	public boolean removeUnit(Unit unit){
		return myUnits.remove(unit);
	}
	
	public boolean equals(Tile other){
		return(this.getX()==other.getX() && this.getY()==other.getY());
	}
	
	public int getX() {
		return (int) this.getValue("x").intValue();
	}
	
	public int getY() {
		return (int) this.getValue("y").intValue();
	}
	
	public List<Unit> getUnits(){
		return myUnits;
	}
	
	
	public Collection<Tile> getTiles(double r){
		int range = (int) r;
		List<Tile> validTiles = new ArrayList<Tile>();
		for (int i = getX() - range; i <= getX() + range; i++){
			for (int j = getY() - range; i <= getY() + range; j++){
				validTiles.add(myMap.getTile(i, j));
			}
		}
		return validTiles;
	}
	
}