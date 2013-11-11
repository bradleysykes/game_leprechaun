package model;

public class Interact extends Ability{

	public Interact(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double useAbility() {
		return 0;		
	}

}
