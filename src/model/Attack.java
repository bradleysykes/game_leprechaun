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
		double enemyDefense = myTarget.getAttributes().getDefense();
		double enemyAttack  = myTarget.getAttributes().getAttack();
		double enemyHealth  = myTarget.getAttributes().getHealth();
		double myDefense = myUnit.getAttributes().getDefense();
		double myAttack = myUnit.getAttributes().getAttack();
		double myHealth = myUnit.getAttributes().getHealth();
		if (myAttack > enemyDefense)
			enemyHealth = enemyHealth + enemyDefense - myAttack;
		if (myDefense < enemyAttack)
			myHealth = myHealth + myDefense - enemyAttack;
		myUnit.getAttributes().setHealth(myHealth);
		myTarget.getAttributes().setHealth(enemyHealth);
		return myAttack - enemyDefense;
	}

}
