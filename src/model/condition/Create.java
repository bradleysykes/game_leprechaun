package model.condition;

import model.Condition;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;

public class Create extends Condition {
	
	public Create(){
		super("Create","",null);
	}
	
	public Create(String goal, Player p) {
		super("Create",goal, p);
	}

	@Override
	public boolean check(){
		for(Unit u : myPlayer.getAllUnits()){
			if(u.getID().equals(this.getID()))
				return true;
		}
		return false;
	}
	
}