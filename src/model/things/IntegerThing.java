package model.things;

public class IntegerThing extends Thing {
	
	public IntegerThing(String name) {
		super(name, "Integer");
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
