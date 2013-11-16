package model;

import model.things.Thing;
import model.things.StatCollection;

public class Resource extends StatCollection {

	//private final String[] RESOURCE_STAT_NAMES = {"Name", "Amount", "Harvest Rate"};

	public Resource(String name, double amount, double harvestRate){
		super("Attributes","Thing");

		this.addThing(new Thing<String>("Name",DEFAULT_STRING));
		this.addThing(new Thing<Double>("Amount",DEFAULT_DOUBLE));
		this.addThing(new Thing<Double>("Harvest Rate",DEFAULT_DOUBLE));
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
