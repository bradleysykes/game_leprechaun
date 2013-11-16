package model;

import java.util.List;

import model.things.StatCollection;
import model.unit.Unit;

public class Attack extends Ability{

	public Attack(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public void prepAbility(){
		if (myParameters.getRange() > 0){
			//assumes correct selection, will need to be more fault-proof
			//myUnit.getTarget(myParameters.getRange());
		}
	}

	@Override
	public void useAbility(){
		List<Unit> units = myTile.getUnits();
		Unit myTarget = units.get(0);
		for(Unit u : units){
			if(u.getStatCollection("Attributes").getValue("Health") < 
					myTarget.getStatCollection("Attributes").getValue("Health")){
				myTarget = u;
			}
		}		
		StatCollection targetAttributes = myTarget.getStatCollection("Attributes");
		StatCollection unitAttributes = myUnit.getStatCollection("Attributes");
		double enemyDefense = targetAttributes.getValue("Defense");
		double enemyAttack  = targetAttributes.getValue("Attack");
		double enemyHealth  = targetAttributes.getValue("Health");
		double myDefense = unitAttributes.getValue("Defense");
		double myAttack = unitAttributes.getValue("Attack");
		double myHealth = unitAttributes.getValue("Health");
		if (myAttack > enemyDefense)
			enemyHealth = enemyHealth + enemyDefense - myAttack;
		if (myDefense < enemyAttack)
			myHealth = myHealth + myDefense - enemyAttack;
		unitAttributes.setStat("Health",myHealth);
		targetAttributes.setStat("Health",enemyHealth);
	}

}
