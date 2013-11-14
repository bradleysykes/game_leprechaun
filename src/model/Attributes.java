package model;

import model.things.DoubleThing;
import model.things.Thing;
import model.things.ThingsThing;

public class Attributes extends ThingsThing {
	
	// Refactor using resource file
	
	public Attributes(){
		super("Attributes","DoubleThing");
		Thing thing = new DoubleThing("Base Health");
		this.addThing(new DoubleThing("Base Health"));
		this.addThing(new DoubleThing("Health"));
		this.addThing(new DoubleThing("Base Attack"));
		this.addThing(new DoubleThing("Attack"));
		this.addThing(new DoubleThing("Base Defense"));
		this.addThing(new DoubleThing("Defense"));
		this.addThing(new DoubleThing("Base Stamina"));
		this.addThing(new DoubleThing("Stamina"));
		for(Thing dt : this.getThings())
			((DoubleThing) dt).setValue(DEFAULT_ATTRIBUTE);
	}

}
