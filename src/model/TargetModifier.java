package model;

import model.abilities.CustomAbility;

public abstract class TargetModifier {
	protected CustomAbility myAbility;

	public TargetModifier(CustomAbility ability) {
		myAbility = ability;
	}
	
	public abstract void modify();

}
