package model.tile;

import java.util.*;

import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.Resources;
import model.Terrain;
import model.stats.Stat;
import model.stats.StatCollection;
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
	
	public GameMap getMap(){
		return myMap;
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
	
	public boolean isOccupied(){
		return myUnits.size()>0;
	}
	
	public boolean containsUnit(Unit u){
		return myUnits.contains(u);
	}
	
	public boolean isOccupiedByOpponent(Player p){
		for(Unit u : myUnits){
			if(!u.getPlayer().equals(p))
				return true;
		}
		return false;
	}

}