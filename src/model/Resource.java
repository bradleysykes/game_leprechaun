package model;

import model.things.DoubleThing;
import model.things.StringThing;
import model.things.ThingsThing;

public class Resource extends ThingsThing {

	//private final String[] RESOURCE_STAT_NAMES = {"Name", "Amount", "Harvest Rate"};

	public Resource(String name, double amount, double harvestRate){
		super("Attributes","DoubleThing");

		this.addThing(new StringThing("Name"));
		this.addThing(new DoubleThing("Amount"));
		this.addThing(new DoubleThing("Harvest Rate"));
	}

	public double harvest(){
		double initAmount = (Double) this.getValue("Amount");
		if(initAmount - (Double) this.getValue("Harvest Rate") > 0)
			this.setValue("Amount", initAmount - (Double) this.getValue("Harvest Rate"));
		else
			this.setValue("Amount", 0);
		return initAmount - (Double) this.getValue("Amount");
	}

}
