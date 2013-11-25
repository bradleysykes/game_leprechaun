package model;

import java.util.ArrayList;
import java.util.List;

import model.stats.StatCollection;
import model.unit.Unit;

public class Player extends StatCollection implements ModelConstants{
	
	protected List<Unit> myUnits;
	protected Condition myWinningCondition;
	protected Model myModel;
	
	public Player(){
		super("Player","Default Player Name");
		this.addStat(new Resources());
		myUnits = new ArrayList<Unit>();
	}
	
	public void setModel(Model m){
		myModel = m;
	}
	
	public Model getModel(){
		return myModel;
	}
	
	public void addNewResourceType(String resourceType, double harvestRate){
		this.getStatCollection("Resources").addStat(new Resource(resourceType,harvestRate,0.0));
	}
	
	// Use negative value for amount to 'charge' the player.
	public boolean adjustResources(String resourceType, double amount){
		Resource r = (Resource) this.getStatCollection(resourceType);
		double finalResources = r.getValue("Amount")+amount;
		if(finalResources>0){
			r.setStat("Amount", finalResources);
			return true;
		}
		return false;
	}
	
	public List<Unit> getAllUnits(){
		return myUnits;
	}
	
	public boolean checkWinningCondition() {
		return myWinningCondition.check();
	}
	
	public boolean equals(Player other){
		return this.getID().equals(other.getID());
	}
	
	public void refresh(){
		for (Unit unit : myUnits){
			unit.refresh();
		}
	}
	
	public void addUnit(Unit addMe) {
		myUnits.add(addMe);
	}

}
