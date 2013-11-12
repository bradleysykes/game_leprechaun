package model;

import model.tile.Tile;
import model.unit.Unit;

public class Interact extends Ability{

	public Interact(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double prepAbility() {
		return 0;		
	}

	@Override
	public double useAbility() {
		return 0;
	}

}
