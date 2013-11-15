package model.tile;

import java.util.*;

import model.ModelConstants;
import model.Resources;
import model.Terrain;
import model.things.DoubleThing;
import model.things.IntegerThing;
import model.things.ThingsThing;
import model.unit.Unit;

public class Tile extends ThingsThing implements ModelConstants{
	
	private List<Unit> myUnits = new ArrayList<Unit>();
	
	public Tile(int x, int y){
		super("Tile","Thing");
		this.addThing(new IntegerThing("x",x));
		this.addThing(new IntegerThing("y",y));
		this.addThing(new DoubleThing("Passability"));
		this.addThing(new IntegerThing("Max Population"));
		this.addThing(new Resources());
		this.addThing(new Terrain());
	}
	
	public boolean addUnit(Unit unit){
		if (myUnits.size() < (Integer) this.getValue("Max Population"))
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
		return (Integer) this.getValue("x");
	}
	
	public int getY() {
		return (Integer) this.getValue("y");
	}
	
	public List<Unit> getUnits(){
		return myUnits;
	}
	
}