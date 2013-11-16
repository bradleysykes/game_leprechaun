package model;

public abstract class TargetModifier {
	protected CustomAbility myAbility;

	public TargetModifier(CustomAbility ability) {
		myAbility = ability;
	}
	
	public abstract void modify();

}
