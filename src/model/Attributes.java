package model;

public class Attributes implements ModelConstants {
	
	private double myBaseHealth;
	private double myBaseAttack;
	private double myBaseDefense;
	private double myBaseStamina;
	private double myHealth;
	private double myAttack;
	private double myDefense;
	private double myStamina;
	
	public Attributes(){
		this.setHealth(DEFAULT_ATTRIBUTE);
		this.setBaseAttack(DEFAULT_ATTRIBUTE);
		this.setBaseDefense(DEFAULT_ATTRIBUTE);
		this.setBaseStamina(DEFAULT_ATTRIBUTE);
		this.setAttack(DEFAULT_ATTRIBUTE);
		this.setDefense(DEFAULT_ATTRIBUTE);
		this.setStamina(DEFAULT_ATTRIBUTE);
	}
	
	public void setAttributes(double hp, double baseAtt, double baseDef, double baseStamina,
			double att, double def, double stamina){
		this.setHealth(hp);
		this.setBaseAttack(baseAtt);
		this.setBaseDefense(baseDef);
		this.setBaseStamina(baseStamina);
		this.setAttack(att);
		this.setDefense(def);
		this.setStamina(stamina);
	}

	public double getHealth() {
		return myHealth;
	}

	public void setHealth(double health) {
		myHealth = health;
	}

	public double getBaseAttack() {
		return myBaseAttack;
	}

	public void setBaseAttack(double baseAttack) {
		myBaseAttack = baseAttack;
	}

	public double getBaseDefense() {
		return myBaseDefense;
	}

	public void setBaseDefense(double baseDefense) {
		myBaseDefense = baseDefense;
	}

	public double getBaseStamina() {
		return myBaseStamina;
	}

	public void setBaseStamina(double baseStamina) {
		myBaseStamina = baseStamina;
	}

	public double getAttack() {
		return myAttack;
	}

	public void setAttack(double attack) {
		myAttack = attack;
	}

	public double getDefense() {
		return myDefense;
	}

	public void setDefense(double defense) {
		myDefense = defense;
	}

	public double getStamina() {
		return myStamina;
	}

	public void setStamina(double stamina) {
		myStamina = stamina;
	}

	public double getBaseHealth() {
		return myBaseHealth;
	}

	public void setBaseHealth(double baseHealth) {
		myBaseHealth = baseHealth;
	}
	
	// create instance via reflection
	// create window using tags for each parameter and input text field from Class.getConstructor

}