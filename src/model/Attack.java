package model;

import model.unit.Unit;

public class Attack extends Ability{
	
	private Unit myTarget;

	public Attack(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double prepAbility(){
		if (myParameters.getRange() > 0){
			//assumes correct selection, will need to be more fault-proof
			myTarget = myUnit.getTarget(myParameters.getRange());
			return useAbility();
		}
		return 0.0;
	}

	@Override
	public double useAbility(){
		double enemyDefense = (Double) myTarget.getAttributes().getThing("Defense").getValue();
		double enemyAttack  = (Double) myTarget.getAttributes().getThing("Attack").getValue();
		double enemyHealth  = (Double) myTarget.getAttributes().getThing("Health").getValue();
		double myDefense = (Double) myUnit.getAttributes().getThing("Defense").getValue();
		double myAttack = (Double) myUnit.getAttributes().getThing("Attack").getValue();
		double myHealth = (Double) myUnit.getAttributes().getThing("Health").getValue();
		if (myAttack > enemyDefense)
			enemyHealth = enemyHealth + enemyDefense - myAttack;
		if (myDefense < enemyAttack)
			myHealth = myHealth + myDefense - enemyAttack;
		myUnit.getAttributes().setThing("Health",myHealth);
		myTarget.getAttributes().setThing("Health",enemyHealth);
		return myAttack - enemyDefense;
	}

}
