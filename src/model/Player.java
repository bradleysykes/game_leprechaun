package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.things.StatCollection;
import model.unit.Unit;

public class Player extends StatCollection implements ModelConstants{
	
	private String myName;
	private List<Unit> myUnits;
	private Condition myWinningCondition;
	private Model myModel;
	
	public Player(){
		super("Player");
		this.addStat(new Resources());
	}
	
//	public Player(String name){
//		myName = name;
//		myResources = new HashMap<String,Double>();
//		myUnits = new ArrayList<Unit>();
//	}
	
	public void setModel(Model m){
		myModel = m;
	}
	
	public String setName(String name){
		myName = name;
		return myName;
	}
	
	public String getName(){
		return myName;
	}
	
	public Model getModel(){
		return myModel;
	}
	
	public void addNewResourceType(String resourceType){
		myResources.put(resourceType,0.0);
	}
	
	// Use negative value for amount to 'charge' the player.
	public boolean adjustResources(String resourceType, double amount){
		double finalResources = myResources.get(resourceType)+amount;
		if(finalResources>0){
			myResources.put(resourceType, myResources.get(resourceType)+amount);
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
		return myName.equals(other.getName());
	}
	
	public void refresh(){
		for (Unit unit : myUnits){
			unit.refresh();
		}
	}

}
