package model.abilities;

import engine.GameEngine;
import model.Ability;
import model.Resources;
import model.stats.StatCollection;
import model.tile.Tile;
import model.unit.Unit;

public class Spawn extends Ability {

	public Spawn(Unit abilityUser) {
		super("Spawn", abilityUser,"List of Spawnable Units");
	}

	@Override
	public void useAbility() {
		Resources cost = (Resources) myTargetUnit.getStatCollection("Resources");
		System.out.println(myTargetUnit.getID()+" "+cost.getStats().size());
		if(myUnit.getPlayer().canAfford(cost)){
			myUnit.getPlayer().chargePlayer(cost);
			myTargetUnit.setPlayer(myUnit.getPlayer());
			Tile t = myUnit.getMap().getNearestValidTile(myUnit);
			Unit test = new Unit(myTargetUnit, myUnit.getPlayer(), t);
			test.setCurrentTile(t);			
			myUnit.getPlayer().getModel().spawnUnit(test);
			myUnit.getPlayer().refresh();
		}
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		myGameEngine.initializeSpawner(myReferences);
	}
	
	@Override
	public Spawn copy(Unit u){
		Spawn toReturn = new Spawn(u);
		for(String s : myReferences){
			toReturn.getReferences().add(s);
		}
		return toReturn;
	}
	
	@Override
	public void refresh(){
		myValid = myReferences.size()>0;
	}

}