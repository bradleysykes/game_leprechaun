package model;

import model.stats.Stat;
import model.stats.StatCollection;

public class Resource extends StatCollection {

	public Resource(String id, double amount, double harvestRate){
		super("Resource",id);
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
	
	
	@Override
	public Resource copy(){
		return new Resource(this.getID(),this.getValue("Amount"),this.getValue("Harvest Rate"));
	}

}