package model;

import model.things.IntegerThing;
import model.things.StringThing;
import model.things.ThingsThing;
import model.unit.Unit;

public class Terrain extends ThingsThing implements ModelConstants {
	
	public Terrain(){
		super("Terrain","Thing");
		this.addThing(new StringThing("Type"));
		this.addThing(new StringThing("Attribute Impacted"));
		this.addThing(new StringThing("Unit Impacted"));
		this.addThing(new IntegerThing("Magnitude"));
	}
	
	public double modifyUnit(Unit unit){
		//return unit.getAttributes.alter(myAttributeImpacted,myMagnitude);
		return (Double) this.getValue("Magnitude");
	}

}
