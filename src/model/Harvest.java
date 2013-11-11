package model;

import java.util.List;

public class Harvest extends Ability{

	public Harvest(Unit abilityUser) {
		super(abilityUser);
	}
	
	@Override
	public void useAbility(){
		List<Resource> resources = myUnit.getCurrentTile().getResourcesOnTile();
		for(Resource r : resources){
			myUnit.getPlayer().adjustResources(r.getName(),r.harvest());
		}
	}

}
