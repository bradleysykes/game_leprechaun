package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Player implements ModelConstants{
	
	private String myName;
	private HashMap<String,Double> myResources;
	private ArrayList<Unit> myUnits;
	
	public Player(){
		this(DEFAULT_NAME);
	}
	
	public Player(String name){
		myName = name;
		myResources = new HashMap<String,Double>();
		myUnits = new ArrayList<Unit>();
	}
	
	public String setName(String name){
		myName = name;
		return myName;
	}
	
	public String getName(){
		return myName;
	}
	
	public void addNewResourceType(String resourceType){
		myResources.put(resourceType,0.0);
	}
	
	public boolean adjustResources(String resourceType, double amount){
		double finalResources = myResources.get(resourceType)+amount;
		if(finalResources>0){
			myResources.put(resourceType, myResources.get(resourceType)+amount);
			return true;
		}
		else {
			return false;
		}
	}
	

}
