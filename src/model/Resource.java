package model;

import model.stats.Stat;
import model.stats.StatCollection;

public class Resource extends StatCollection {

	//private final String[] RESOURCE_STAT_NAMES = {"Name", "Amount", "Harvest Rate"};

	public Resource(String name, double amount, double harvestRate){
		super("Resource",name);
		//this.addStat(new Stat("Name",DEFAULT_STRING));
		this.addStat(new Stat("Amount",amount));
		this.addStat(new Stat("Harvest Rate",harvestRate));
	}

	public double harvest(){
		double initAmount = this.getValue("Amount");
		if(initAmount - this.getValue("Harvest Rate") > 0)
			this.setStat("Amount", initAmount - this.getValue("Harvest Rate"));
		else
			this.setStat("Amount", 0.0);
		return initAmount - this.getValue("Amount");
	}

}