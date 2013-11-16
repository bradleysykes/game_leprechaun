package model.targets;

import model.CustomAbility;
import model.TargetModifier;

public class ModifyRange extends TargetModifier {
	private int myRange;

	public ModifyRange(CustomAbility ability, int range) {
		super(ability);
		myRange = range;
	}

	@Override
	public void modify() {
		myAbility.setRange(myRange);
	}

}
