package model;

import model.things.Thing;
import model.things.StatCollection;
import model.unit.Unit;

public class Terrain extends StatCollection implements ModelConstants {
	
	public Terrain(){
		super("Terrain","Thing");
		this.addThing(new Thing<String>("Type",DEFAULT_STRING));
		this.addThing(new Thing<String>("Attribute Impacted",DEFAULT_STRING));
		this.addThing(new Thing<String>("Unit Impacted",DEFAULT_STRING));
		this.addThing(new Thing<Integer>("Magnitude",DEFAULT_INT));
	}
	
	public double modifyUnit(Unit unit){
		//return unit.getAttributes.alter(myAttributeImpacted,myMagnitude);
		return (Double) this.getValue("Magnitude");
	}

}
