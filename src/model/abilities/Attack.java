package model.abilities;

import java.util.List;

import engine.GameEngine;

import model.Ability;
import model.Attributes;
import model.stats.StatCollection;
import model.unit.Unit;

/**
 * Allows a unit to attack another Unit. Currently, this ability acts upon a tile.
 * The unit with the lowest health on the tile is attacked. Damage is dealt to both 
 * the attacking and defending unit through simple arithmetic on their Attributes.
 * @author Timo and John
 *
 */
public class Attack extends Ability{

	public Attack(Unit abilityUser) {
		super("Attack", abilityUser);
	}

	@Override
	public void useAbility(){
		if(!myValid) return;
		List<Unit> units = myTile.getUnits();
		Unit myTarget = units.get(0);
		for(Unit u : units){
			if(u.getStatCollection("Attributes").getValue("Health") < 
					myTarget.getStatCollection("Attributes").getValue("Health")){
				myTarget = u;
			}
		}		
		Attributes targetAttributes = (Attributes) myTarget.getStatCollection("Attributes");
		Attributes unitAttributes = (Attributes) myUnit.getStatCollection("Attributes");
		double enemyDefense = targetAttributes.getDefense();
		double enemyAttack  = targetAttributes.getAttack();
		double enemyHealth  = targetAttributes.getValue("Health");
		double myDefense = unitAttributes.getDefense();
		double myAttack = unitAttributes.getAttack();
		double myHealth = unitAttributes.getValue("Health");
		if (myAttack > enemyDefense)
			enemyHealth = enemyHealth + enemyDefense - myAttack;
		if (myDefense < enemyAttack)
			myHealth = myHealth + myDefense - enemyAttack;
		unitAttributes.setStat("Health",myHealth);
		targetAttributes.setStat("Health",enemyHealth);
		myValid = false;
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		myGameEngine.highlightTiles(myUnit.getCurrentTile().getTiles(myUnit.getStatCollection("Attributes").getValue("Range")));
	}

}
