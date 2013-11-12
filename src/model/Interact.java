package model;

import model.unit.Unit;

public class Interact extends Ability{

	public Interact(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double prepAbility() {
		return 0;		
	}

}
