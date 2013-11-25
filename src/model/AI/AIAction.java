package model.AI;

import model.Ability;

public class AIAction {
	
	private Ability myAbility;
	
	public AIAction(Ability a){
		myAbility = a;
	}
	
	public Ability getAbility(){
		return myAbility;
	}

}
