package model;

import java.util.ArrayList;
import java.util.List;

import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class Player extends StatCollection implements ModelConstants{
	
	protected List<Unit> myUnits;
	protected WinCondition myWinCondition = new WinCondition(this);
	protected Model myModel;
	
	public Player(){
		this("Defuault Player Name");
	}
	
	public Player(String id){
		super("Player",id);
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
	
	public void chargePlayer(Resources charged){
		for(Stat s : charged.getStats()){
			Resource r = (Resource) s;
			this.adjustResources(r.getID(),-r.getValue("Amount"));
		}
	}
	
	public boolean playerCanAfford(Resource charged){
		Resource r = (Resource) this.getStatCollection(charged.getID());
		double playerResourceAmount = r.getValue("Amount");
		double finalResources = playerResourceAmount - charged.getValue("Amount");
		if(finalResources>0){
			return true;
		}
		return false;
	}
	
	public boolean canAfford(Resources resources){
		for(Stat s : resources.getStats()){
			Resource r = (Resource) s;
			if(!playerCanAfford(r))
				return false;
		}
		return true;
	}
	
	public List<Unit> getAllUnits(){
		return myUnits;
	}
	
	public boolean checkWinningCondition() {
		return myWinCondition.check();
	}
	
	public boolean equals(Player other){
		return this.getID().equals(other.getID());
	}
	
	public void refresh(){
		for (Unit unit : myUnits){
			System.out.println("Player is refreshing unit: "+unit.getID());
			unit.refresh();
		}
	}
	
	public void addUnit(Unit addMe) {
		myUnits.add(addMe);
	}

}
