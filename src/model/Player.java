package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.unit.Unit;

public class Player implements ModelConstants{
	
	private String myName;
	private HashMap<String,Double> myResources;
	private List<Unit> myUnits;
	private Condition myWinningCondition;
	private Controller myController;
	
	public Player(){
		this(DEFAULT_STRING);
	}
	
	public Player(String name){
		myName = name;
		myResources = new HashMap<String,Double>();
		myUnits = new ArrayList<Unit>();
	}
	
	public void setController(Controller c){
		myController = c;
	}
	
	public String setName(String name){
		myName = name;
		return myName;
	}
	
	public String getName(){
		return myName;
	}
	
	public Controller getController(){
		return myController;
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
