package model;

import model.things.Thing;
import model.unit.Unit;

public class Harvest extends Ability{

	public Harvest(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public void useAbility(){
		Resources resources = (Resources) myUnit.getCurrentTile().getThing("Resources");
		for(Thing r : resources.getThings()){
			Resource resource = (Resource) r;
			myUnit.getPlayer().adjustResources((String) resource.getValue("Name"),((Resource) r).harvest());
		}
	}
	
	@Override
	public void prepAbility(){
		// Doesn't require special preparation - works with current tile.
		useAbility();
	}

}
