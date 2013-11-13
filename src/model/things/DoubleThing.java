package model.things;

public class DoubleThing extends Thing{
	
	public DoubleThing(String s) {
		super(s,"Double");
	}
	
	public void setValue(double value){
		myValue = value;
	}

	public void setValue(String s) {
		myValue = Double.parseDouble(s);
	}
	
	public Double getValue(){
		return (Double) myValue;
	}

	@Override
	public void setValue(Object o) {
		myValue = (Double) o;
	}

}
