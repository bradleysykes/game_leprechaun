package model;
import java.util.*;

public class Ability {
	protected Unit myUnit;
	protected ArrayList<Parameter> myParameters = new ArrayList<Parameter>();

	public Ability(Unit abilityUser) {
		myUnit = abilityUser;
	}
	
	public int useAbility(){
		
		return 0;
	}
	
	public Parameter addParameter(Parameter p){
		myParameters.add(p);
		return p;
	}
	
}
