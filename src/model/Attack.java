package model;

import model.unit.Unit;

public class Attack extends Ability{
	
	private Unit myTarget;

	public Attack(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public void prepAbility(){
		if (myParameters.getRange() > 0){
			//assumes correct selection, will need to be more fault-proof
			myTarget = myUnit.getTarget(myParameters.getRange());
			useAbility();
		}
	}

	@Override
	public void useAbility(){
		double enemyDefense = (Double) myTarget.getAttributes().getValue("Defense");
		double enemyAttack  = (Double) myTarget.getAttributes().getValue("Attack");
		double enemyHealth  = (Double) myTarget.getAttributes().getValue("Health");
		double myDefense = (Double) myUnit.getAttributes().getValue("Defense");
		double myAttack = (Double) myUnit.getAttributes().getValue("Attack");
		double myHealth = (Double) myUnit.getAttributes().getValue("Health");
		if (myAttack > enemyDefense)
			enemyHealth = enemyHealth + enemyDefense - myAttack;
		if (myDefense < enemyAttack)
			myHealth = myHealth + myDefense - enemyAttack;
		myUnit.getAttributes().setValue("Health",myHealth);
		myTarget.getAttributes().setValue("Health",enemyHealth);
	}

}
