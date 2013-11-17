package model.abilities;

import model.Ability;
import model.unit.Unit;

public class Interact extends Ability{

	public Interact(Unit abilityUser) {
		super("Interact",abilityUser);
	}

	@Override
	public void prepAbility() {
	}

	@Override
	public void useAbility() {
		if(!myValid) return;
		myValid = false;
	}

}
