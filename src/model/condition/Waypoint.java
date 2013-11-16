package model.condition;

import model.Condition;
import model.tile.Tile;
import model.unit.Unit;

public class Waypoint extends Condition {
	private Unit myUnit;
	private Tile myTile;

	public Waypoint(Unit wayfarer, Tile destination) {
		super("Waypoint");
		myUnit = wayfarer;
		myTile = destination;
	}
	
	@Override
	public boolean check(){
		return (myUnit.getCurrentTile().equals(myTile));
	}

}
