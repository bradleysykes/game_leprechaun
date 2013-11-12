package model;

public class Attack extends Ability{

	public Attack(Unit abilityUser) {
		super(abilityUser);
	}
	
	@Override
	public double useAbility(){
		if (myParameters.getRange() > 0){
			//assumes correct selection, will need to be more fault-proof
			Unit enemyUnit = myUnit.getTarget(myParameters.getRange());
			double enemyDefense = enemyUnit.getAttributes().getDefense();
			double enemyAttack  = enemyUnit.getAttributes().getAttack();
			double enemyHealth  = enemyUnit.getAttributes().getHealth();
			double myDefense = myUnit.getAttributes().getDefense();
			double myAttack = myUnit.getAttributes().getAttack();
			double myHealth = myUnit.getAttributes().getHealth();
			if (myAttack > enemyDefense)
				enemyHealth = enemyHealth + enemyDefense - myAttack;
			if (myDefense < enemyAttack)
				myHealth = myHealth + myDefense - enemyAttack;
			myUnit.getAttributes().setHealth(myHealth);
			enemyUnit.getAttributes().setHealth(enemyHealth);
			return myAttack - enemyDefense;
		}
		return 0.0;
	}

}
