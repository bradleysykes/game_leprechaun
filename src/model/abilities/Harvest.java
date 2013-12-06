package model.abilities;

import engine.GameEngine;
import model.Ability;
import model.Resource;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class Harvest extends Ability{

	public Harvest(Unit abilityUser) {
		super("Harvest",abilityUser);
	}

	@Override
	public void useAbility(){
		if(!myValid) return;
		StatCollection resources = myUnit.getCurrentTile().getStatCollection("Resources");
		for(Stat r : resources.getStats()){
			Resource resource = (Resource) r;
			myUnit.getPlayer().adjustResources(resource.getID(), resource.harvest());
		}
		myValid = false;
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		useAbility();
		// Doesn't require outside input.
	}
	
	@Override
	public Harvest copy(Unit u){
		return new Harvest(u);
	}

}
