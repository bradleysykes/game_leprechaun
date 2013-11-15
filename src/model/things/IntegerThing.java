package model.things;

public class IntegerThing extends Thing {
	
	public IntegerThing(String name) {
		super(name, "Integer");
		myValue = DEFAULT_INT;
	}
	
	public IntegerThing(String name, int val){
		this(name);
		myValue = val;
	}
	
	public Integer getValue(){
		return (Integer) myValue;
	}

	public void setValue(String s) {
		myValue = Integer.parseInt(s);
	}
	
	public void setValue(int value){
		myValue = value;
	}

	@Override
	public void setValue(Object o) {
		myValue = (Integer) o;
	}

}
