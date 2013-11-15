package model;

import model.things.DoubleThing;
import model.things.ThingsThing;

public class Attributes extends ThingsThing {
	
	// Refactor using resource file
	private final String[] ATTRIBUTE_NAMES = {"Base Help", "Health", "Base Attack", "Attack",
			"Base Defense", "Defense", "Base Stamina", "Stamina"};
	
	public Attributes(){
		super("Attributes","Thing");
		for(String s : ATTRIBUTE_NAMES){
			this.addThing(new DoubleThing(s));
		}
	}

}
