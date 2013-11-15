package model;

public class Parameters implements ModelConstants {
	
	private int myRange;
	private int myRadius;
	private int myPower;

	public Parameters(){
		this.setRange(DEFAULT_INT);
		this.setRadius(DEFAULT_INT);
		this.setPower(DEFAULT_INT);
	}
	
	public void setParameters(int range, int radius, int power){
		this.setRange(range);
		this.setRadius(radius);
		this.setPower(power);
	}

	public int getRange() {
		return myRange;
	}

	public void setRange(int Range) {
		myRange = Range;
	}

	public int getRadius() {
		return myRadius;
	}

	public void setRadius(int Radius) {
		myRadius = Radius;
	}

	public int getPower() {
		return myPower;
	}

	public void setPower(int Power) {
		myPower = Power;
	}
	
	// create instance via reflection
	// create window using tags for each parameter and input text field from Class.getConstructor

}
