package model;

import model.unit.Unit;

public class Terrain implements ModelConstants {
	
	private String myName = DEFAULT_NAME;;
	private int myAttributeImpacted = 0;
	private double myMagnitude = 0;
	
	public Terrain(){
	}
	
	public Terrain(String name){
		myName = name;
	}
	
	public double modifyUnit(Unit unit){
		//return unit.getAttributes.alter(myAttributeImpacted,myMagnitude);
		return myMagnitude;
	}

	public String getName() {
	    return myName;
	}
	
	public void setName(String name) {
	    myName = name;
	}
}
