package model.abilities;

import java.util.List;

import engine.GameEngine;

import model.Ability;
import model.Attributes;
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
		List<Unit> units = this.myTargetTile.getUnits();
		Unit myTarget = units.get(0);
		for(Unit u : units){
			if(u.getStatCollection("Attributes").getValue("Health") < 
					myTarget.getStatCollection("Attributes").getValue("Health")){
				myTarget = u;
			}
		}
		System.out.println("My name is "+this.myUnit.getID()+". My target's name is "+myTarget.getID()+".");
		Attributes targetAttributes = (Attributes) myTarget.getStatCollection("Attributes");
		Attributes unitAttributes = (Attributes) myUnit.getStatCollection("Attributes");
		double enemyDefense = targetAttributes.getDefense();
		double enemyAttack  = targetAttributes.getAttack();
		double enemyHealth  = targetAttributes.getValue("Health");
		double myDefense = unitAttributes.getDefense();
		double myAttack = unitAttributes.getAttack();
		double myHealth = unitAttributes.getValue("Health");
		System.out.println(myDefense+" "+myAttack+" "+myHealth);
		System.out.println(enemyDefense+" "+enemyAttack+" "+enemyHealth);
		if (myAttack > enemyDefense)
			enemyHealth = enemyHealth + enemyDefense - myAttack;
		else
			enemyHealth--;
//		if (myDefense < enemyAttack)			// Do we want units to counter-attack on that same move?
//			myHealth = myHealth + myDefense - enemyAttack;
//		else if(enemyAttack!=0)
//			myHealth--;
//		if(myHealth<=0){
//			myUnit.getPlayer().removeUnit(myUnit);
//			myUnit.getCurrentTile().removeUnit(myUnit);
//			myUnit.getPlayer().getModel().destroyUnit(myUnit);
//		}
//		else{
//			unitAttributes.setStat("Health",myHealth);
//			myValid = false;
//		}
		if(enemyHealth<=0){
			myTarget.getPlayer().removeUnit(myTarget);
			myTarget.getCurrentTile().removeUnit(myTarget);
			myTarget.getPlayer().getModel().destroyUnit(myTarget);
		}
		else{
			targetAttributes.setStat("Health",enemyHealth);
		}
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		myGameEngine.highlightTiles(myUnit.getMap().getTilesInRadius
				(myUnit.getStatCollection("Attributes").getValue("Range"),myUnit.getCurrentTile()));
	}

	@Override
	public Ability copy(Unit u){
		return new Attack(u);
	}

	@Override
	public void refresh(){
		myValid = true;
		if(((Attributes) myUnit.getStatCollection("Attributes")).getAttack() == 0)
			myValid = false;
	}

}
