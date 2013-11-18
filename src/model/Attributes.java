package model;

import model.things.Stat;
import model.things.StatCollection;

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
