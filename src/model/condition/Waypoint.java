package model.condition;

import model.tile.Tile;
import model.unit.Unit;

public class Waypoint extends Condition {
	private Unit myUnit;
	private Tile myTile;

	public Waypoint(Unit wayfarer, Tile destination) {
		myUnit = wayfarer;
		myTile = destination;
	}
	
	@Override
	public boolean check(){
		return (myUnit.getCurrentTile().equals(myTile));
	}

}