package model.things;

import java.util.List;

public class ThingsThing extends Thing {
	
	public ThingsThing(String name, String fieldType){
		super(name,fieldType);
	}	
	
	protected List<Thing> myThings;
	
	public void addThing(Thing t){
		myThings.add(t);
	}
	
	public void setThings(List<Thing> things){
		myThings = things;
	}
	
	public List<Thing> getThings(){
		return myThings;
	}
	
	public void setThing(String name, Object value){
		this.getThing(name).setValue(value);
	}
	
	public Object getValue(String name){
		return this.getThing(name).getValue();
	}
	
	public Thing getThing(String name){
		for(Thing t : myThings){
			if(t.getName().equals(name))
				return t;
		}
		return null;
	}

	@Override
	public Object getValue() {
		// If this returns null, know must dig deeper.
		return null;
	}

	@Override
	public void setValue(String s) {
		// do nothing
	}

	@Override
	public void setValue(Object o) {
		// do nothing		
	}

}
