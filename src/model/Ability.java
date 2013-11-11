package model;
import java.util.*;

public abstract class Ability {
	protected Unit myUnit;
	protected ArrayList<Parameter> myParameters = new ArrayList<Parameter>();

	public Ability(Unit abilityUser) {
		myUnit = abilityUser;
	}
	
	public abstract void useAbility();
	
	public Parameter addParameter(Parameter p){
		myParameters.add(p);
		return p;
	}
	
}
