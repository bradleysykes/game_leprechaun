package model.condition;

import model.Condition;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;

public class Waypoint extends Condition {
	private Unit myUnit;
	private Tile myTile;
	
	public Waypoint(){
		super("Waypoint",null);
	}

	public Waypoint(Unit wayfarer, Player p, Tile destination) {
		super("Waypoint", p);
		myUnit = wayfarer;
		myTile = destination;
	}
	
	@Override
	public boolean check(){
		return (myUnit.getCurrentTile().equals(myTile));
	}

}
