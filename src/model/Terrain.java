package model;

public class Terrain implements ModelConstants {
	
	private String myName;
	
	public Terrain(){
		myName = DEFAULT_NAME;
	}
	
	public Terrain(String name){
		myName = name;
	}
	
	public double modifyUnit(Unit unit){
		// return unit.buff(myName);
		return 0;
	}

	// Added these methods for data (Alex) 
	public String getName() {
	    return myName;
	}
	
	public void setName(String name) {
	    myName = name;
	}
}
