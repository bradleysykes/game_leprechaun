package model.targets;

import model.CustomAbility;
import model.TargetModifier;

public class ModifyRadius extends TargetModifier {
	private int myRadius;

	public ModifyRadius(CustomAbility ability, int radius) {
		super(ability);
		myRadius = radius;
	}

	@Override
	public void modify() {
		myAbility.setRadius(myRadius);
	}

}
