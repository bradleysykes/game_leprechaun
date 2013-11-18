package model;

import model.abilities.Attack;
import model.abilities.Harvest;
import model.movement.BudgetMove;
import model.stats.StatCollection;
import model.unit.Unit;

/**
 * Stores a collection of Abilities.
 * @author Timo and John
 *
 */
public class Abilities extends StatCollection{	

	public Abilities(Unit unit) {
		super("Abilities");
		this.addStat(new Attack(unit));
		this.addStat(new BudgetMove(unit));
		this.addStat(new Harvest(unit));
	}
	
	public void addAbility(){
		
	}
}
