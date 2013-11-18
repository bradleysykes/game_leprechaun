package model.condition;

import model.Condition;
import model.Player;
import model.unit.Unit;

public class Defeat extends Condition {
	private String myUnitID;

	public Defeat(String target, Player p) {
		super("Defeat", p);
		myUnitID = target;
	}
	
	@Override
	public boolean check(){
		
		return false;
	}

}
