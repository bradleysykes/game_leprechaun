package model;

import java.util.List;

import model.unit.Unit;

public class Harvest extends Ability{

	public Harvest(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double useAbility(){
		List<Resource> resources = myUnit.getCurrentTile().getResourcesOnTile();
		for(Resource r : resources){
			myUnit.getPlayer().adjustResources(r.getName(),r.harvest());
		}
		return 0;
	}
	
	@Override
	public double prepAbility(){
		return useAbility();
	}

}
