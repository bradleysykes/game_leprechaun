package model;

import model.unit.Unit;

public abstract class Ability {
	protected Unit myUnit;
	protected Parameters myParameters = new Parameters();

	public Ability(Unit abilityUser) {
		myUnit = abilityUser;
	}
	public double prepAbility(){
		return 0.0;
	}
	
	public double useAbility(){
		return 0.0;		
	}
	
}
