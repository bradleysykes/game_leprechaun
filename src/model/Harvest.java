package model;

import model.things.Stat;
import model.things.StatCollection;
import model.unit.Unit;

public class Harvest extends Ability{

	public Harvest(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double useAbility(){
		StatCollection resources = myUnit.getCurrentTile().getStatCollection("Resources");
		for(Stat r : resources.getStats()){
			Resource resource = (Resource) r;
			myUnit.getPlayer().adjustResources(resource.getID(), resource.harvest());
		}
		return 0;
	}
	
	@Override
	public double prepAbility(){
		// Doesn't require special preparation - works with current tile.
		return useAbility();
	}

}
