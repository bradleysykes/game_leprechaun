package model.things;

public class StringThing extends Thing {
	
	public StringThing(String name) {
		super(name, "String");
	}

	public void setValue(String s) {
		myValue = s;
	}

	public String getValue() {
		return (String) myValue;
	}

	@Override
	public void setValue(Object o) {
		myValue = (String) o;
	}

}
