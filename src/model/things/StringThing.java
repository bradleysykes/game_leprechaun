package model.things;

public class StringThing extends Thing {
	
	public StringThing(String name) {
		super(name, "String");
		myValue = DEFAULT_STRING;
	}
	
	public StringThing(String name, String val){
		this(name);
		myValue = val;
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
