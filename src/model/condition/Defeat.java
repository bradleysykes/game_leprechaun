package model.condition;

import model.unit.Unit;

public class Defeat extends Condition {
	private Unit myUnit;

	public Defeat(Unit target) {
		myUnit = target;
	}
	
	@Override
	public boolean check(){
		if (myUnit == null)
			return true;
		return !myUnit.isAlive();
	}

}