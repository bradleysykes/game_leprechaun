package model;

import java.util.ArrayList;
import java.util.List;
import model.unit.Unit;

public class CustomAbility extends Ability {
	protected List<Effect> myTargetModifiers = new ArrayList<Effect>();
	protected Parameters myParameters = new Parameters();
	protected double myRange;

	public CustomAbility(Unit abilityUser) {
		super(abilityUser);
		//myRange = abilityUser.getAttributes().getThing("AttackRange");
	}

	@Override
	public void prepAbility() {
	}

	@Override
	public void useAbility() {
	}

}
