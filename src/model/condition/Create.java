package model.condition;

import model.Condition;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;

public class Create extends Condition {
	
	private Unit myUnit;

	public Create(){
		super("Create",null);
	}
	
	public Create(Unit goal, Player p) {
		super("Create", p);
		myUnit = goal;
	}

	@Override
	public boolean check(){
		for (Tile tile : myUnit.getMap().getAllTiles()){
			for (Unit unit : tile.getUnits()){
				if (unit.equals(myUnit)){
					return true;
				}
			}
		}
		return false;
	}
	
}