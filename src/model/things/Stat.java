package model.things;

import model.ModelConstants;

public class Stat implements ModelConstants {
	
	protected String myName;
	protected Double myValue;
	
	public Stat(String name){
		myName = name;
		myValue = DEFAULT_DOUBLE;
	}
	
	public Stat(String name, Double initVal){
		myName = name;
		myValue = initVal;
	}
	
	public String getField(){
		return myValue.getClass().toString();
	}
	
	public String getName(){
		return myName;
	}
	
	public Double getValue(){
		return myValue;
	}

	public void setValue(Double val){
		myValue = val;
	}
	

}
