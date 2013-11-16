package model.condition;

import model.Condition;
import model.unit.Unit;

public class Defeat extends Condition {
	private Unit myUnit;

	public Defeat(Unit target) {
		super("Create");
		myUnit = target;
	}
	
	@Override
	public boolean check(){
		if (myUnit == null)
			return true;
		return false;
	}

}
