package model.things;

import model.ModelConstants;

public abstract class Thing implements ModelConstants {
	
	// REFACTOR S.T. NAMES ARE READ FROM RESOURCE FILE (support languages)
	
	protected String myName;
	protected String myField;
	protected Object myValue;
	
	public Thing(String name, String field){
		myName = name;
		myField = field;
	}
	
	public String getField(){
		return myField;
	}
	
	public String getName(){
		return myName;
	}
	
	public abstract Object getValue();
	
	public abstract void setValue(String s);
	
	public abstract void setValue(Object o);
	

}
