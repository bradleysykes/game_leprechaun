package model;

import model.stats.Stat;
import model.stats.StatCollection;

/**
 * Explicitly defines the stats of a unit.
 * @author Timo and John
 *
 */
public class Attributes extends StatCollection {
	
	// Refactor using resource file
	private final String[] ATTRIBUTE_NAMES = {"Max Health", "Health", "Base Attack", "Attack",
			"Base Defense", "Defense", "Base Stamina", "Stamina", "Range"};
	
	public Attributes(){
		super("Attributes");
		for(String name : ATTRIBUTE_NAMES){
			this.addStat(new Stat(name));
		}
	}

}
