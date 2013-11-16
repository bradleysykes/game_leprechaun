package model;

import model.things.Stat;
import model.things.StatCollection;
import model.unit.Unit;

public class Harvest extends Ability{

	public Harvest(Unit abilityUser) {
		super("Harvest",abilityUser);
	}

	@Override
	public void useAbility(){
		StatCollection resources = myUnit.getCurrentTile().getStatCollection("Resources");
		for(Stat r : resources.getStats()){
			Resource resource = (Resource) r;
			myUnit.getPlayer().adjustResources(resource.getID(), resource.harvest());
		}
	}
	
	@Override
	public void prepAbility(){
		// Doesn't require special preparation - works with current tile.
		useAbility();
	}

}
