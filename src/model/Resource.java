package model;

public class Resource {
	
	private String myName;
	private double myAmount;
	private double myHarvestRate;
	
	public Resource(String name, double amount, double harvestRate){
		setName(name);
		myAmount = amount;
		myHarvestRate = harvestRate;
	}
	
	public double harvest(){
		double initAmount = myAmount;
		if(myAmount - myHarvestRate > 0)
			myAmount = myAmount - myHarvestRate;
		else
			myAmount = 0;
		return initAmount - myAmount;
	}

	public String getName() {
		return myName;
	}

	public void setName(String name) {
		myName = name;
	}
	
	public double getAmount() {
	    return myAmount;
	}
	
	public double getHarvestRate() {
	    return myHarvestRate;
	}

}
