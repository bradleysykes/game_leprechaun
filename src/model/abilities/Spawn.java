package model.abilities;

import engine.GameEngine;
import model.Ability;
import model.unit.Unit;

public class Spawn extends Ability {

	public Spawn(Unit abilityUser) {
		super("Spawner", abilityUser,"List of Spawnable Units");
	}

	@Override
	public void useAbility() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		//myGameEngine.requestStringFromList(myReferences);
	}

}
