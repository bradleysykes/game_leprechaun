package model.abilities;

import engine.GameEngine;
import model.Ability;
import model.unit.Unit;

public class Interact extends Ability{

	public Interact(Unit abilityUser) {
		super("Interact",abilityUser);
	}

	@Override
	public void useAbility() {
		if(!myValid) return;
		myValid = false;
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		// TODO Auto-generated method stub
		
	}

}
