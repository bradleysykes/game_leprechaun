package model;
import java.util.*;

public abstract class Ability {
	protected Unit myUnit;
	protected ArrayList<Parameters> myParameters = new ArrayList<Parameters>();
	protected int myRange;
	protected int myRadius;

	public Ability(Unit abilityUser) {
		myUnit = abilityUser;
		myRange = 0;
		myRadius = 0;
	}
	public double useAbility(){
		return 0.0;
	}
	
/*	
	public Parameters addParameter(Parameters p){
		myParameters.add(p);
		return p;
	}*/
	
	public int setRange(int range){
		return myRange = range;
	}
	
	public int setRadius(int radius){
		return myRadius = radius;
	}
	
}
