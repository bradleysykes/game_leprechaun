package model;

import model.unit.Unit;
import java.util.*;

public abstract class Ability{
	
	protected Unit myUnit;
	protected Parameters myParameters;

	public Ability(Unit abilityUser) {
		myUnit = abilityUser;
	}
	
	public abstract void prepAbility();
	
	public abstract void useAbility();
	
}
