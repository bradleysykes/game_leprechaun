package model.abilities;

import engine.GameEngine;
import model.Ability;
import model.unit.Unit;

public class Spawn extends Ability {

	public Spawn(Unit abilityUser) {
		super("Spawn", abilityUser,"List of Spawnable Units");
	}

	@Override
	public void useAbility() {
		myTargetUnit.setPlayer(myUnit.getPlayer());
		myTargetUnit.setCurrentTile(myUnit.getMap().getNearestValidTile(myUnit));
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		myGameEngine.requestStringFromList(myReferences);
	}
	
	@Override
	public Spawn copy(Unit u){
		Spawn toReturn = (Spawn) this.copy();
		toReturn.setUnit(u);
		return toReturn;
	}

}