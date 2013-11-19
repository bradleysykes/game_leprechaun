package model;

import model.stats.Stat;
import model.stats.StatCollection;

/**
 * Explicitly defines the stats of a unit.
 * @author Timo and John
 *
 */
public class Attributes extends StatCollection {
	
	private Double myAttack = DEFAULT_DOUBLE;
	private Double myDefense = DEFAULT_DOUBLE;
	
	// Refactor using resource file
	private final String[] ATTRIBUTE_NAMES = {"Health", "Max Health", "Base Attack", "Base Defense", 
			"Stamina", "Base Stamina", "Range"};
	
	public Attributes(){
		super("Attributes");
		for(String name : ATTRIBUTE_NAMES){
			this.addStat(new Stat(name));
		}
	}
	
	public void refresh(){
		myAttack = this.getValue("Base Attack");
		myDefense = this.getValue("Base Defense");
		this.setStat("Stamina",this.getValue("Base Stamina"));
	}
	
	public void setAttack(double attack){
		myAttack = attack;
	}
	
	public Double getAttack(){
		return myAttack;
	}
	
	public void setDefense(double defense){
		myDefense = defense;
	}
	
	public Double getDefense(){
		return myDefense;
	}	

}
