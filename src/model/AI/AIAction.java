package model.AI;

import model.Ability;

public class AIAction {
	
	private Ability myAbility;
	private Double myEfficiency;
	
	public AIAction(Ability a, Double e){
		myAbility = a;
		myEfficiency = e;
	}
	
	public Ability getAbility(){
		return myAbility;
	}
	
	public Double getEfficiency(){
		return myEfficiency;
	}

}
