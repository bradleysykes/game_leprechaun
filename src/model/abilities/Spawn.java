package model.abilities;

import engine.GameEngine;
import model.Ability;
import model.Resources;
import model.tile.Tile;
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
			Tile toPlaceAt = myUnit.getMap().getNearestValidTile(myUnit);
			System.out.println(toPlaceAt.getX() + " " + toPlaceAt.getY());
			Unit test = new Unit(myTargetUnit, myUnit.getPlayer(),
					myUnit.getMap().getNearestValidTile(myUnit));
			myUnit.getPlayer().getModel().spawnUnit(test);
		}
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		for(String s : myReferences)
			System.out.println(s+" TIMO");
		myGameEngine.initializeSpawner(myReferences);
	}
	
	@Override
	public Spawn copy(Unit u){
		Spawn toReturn = new Spawn(u);
		for(String s : myReferences)
			toReturn.getReferences().add(s);
		return toReturn;
	}

}