package model.abilities;

import engine.GameEngine;
import model.Ability;
import model.Resources;
import model.unit.Unit;

public class Spawn extends Ability {

	public Spawn(Unit abilityUser) {
		super("Spawn", abilityUser,"List of Spawnable Units");
		myReferences.add("Soldier");
	}

	@Override
	public void useAbility() {
		Resources cost = (Resources) myTargetUnit.getStatCollection("Resources");
		if(myUnit.getPlayer().canAfford(cost)){
			myUnit.getPlayer().chargePlayer(cost);
			myTargetUnit.setPlayer(myUnit.getPlayer());
			myUnit.getPlayer().getModel().spawnUnit(new Unit(myTargetUnit, myUnit.getPlayer(),
					myUnit.getMap().getNearestValidTile(myUnit)));
		}
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