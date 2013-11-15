package model.things;

public class DoubleThing extends Thing{
	
	public DoubleThing(String name) {
		super(name,"Double");
		myValue = DEFAULT_DOUBLE;
	}
	
	public DoubleThing(String name, Double val){
		this(name);
		myValue = val;
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
