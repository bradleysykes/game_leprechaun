package model;

public class Attributes implements ModelConstants {
	
	private double myHealth;
	private double myBaseAttack;
	private double myBaseDefense;
	private double myBaseStamina;
	private double myAttack;
	private double myDefense;
	private double myStamina;
	
	public Attributes(){
		myHealth = DEFAULT_ATTRIBUTE;
		myAttack = DEFAULT_ATTRIBUTE;
		myDefense = DEFAULT_ATTRIBUTE;
		myStamina = DEFAULT_ATTRIBUTE;
	}
	

}
