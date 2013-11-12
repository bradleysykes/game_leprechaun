package model.condition;

import java.util.*;

public class Conditions {
	private Collection<Condition> myConditions = new ArrayList<Condition>();

	public Conditions() {
	}
	
	public boolean check(){
		for (Condition c : myConditions){
			if(!c.check())
				return false;
		}
		return true;
	}

	public boolean addCondition(Condition c){
		return myConditions.add(c);
	}
	
	public boolean removeCondition(Condition c){
		return myConditions.remove(c);
	}
	
}
