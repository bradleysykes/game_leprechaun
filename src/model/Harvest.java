package model;

import model.things.Thing;
import model.unit.Unit;

public class Harvest extends Ability{

	public Harvest(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double useAbility(){
		Resources resources = (Resources) myUnit.getCurrentTile().getThing("Resources");
		for(Thing r : resources.getThings()){
			myUnit.getPlayer().adjustResources(r.getName(),((Resource) r).harvest());
		}
		return 0;
	}
	
	@Override
	public double prepAbility(){
		// Doesn't require special preparation - works with current tile.
		return useAbility();
	}

}
