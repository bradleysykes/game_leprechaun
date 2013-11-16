package model.things;

import java.util.ArrayList;
import java.util.List;

public class StatCollection extends Stat {
	
	public StatCollection(String name){
		super(name,null);
	}
	
	protected List<Stat> myStats = new ArrayList<Stat>();
	
	public void addThing(Stat t){
		myStats.add(t);
	}
	
	public void removeThing(Stat t){
		myStats.remove(t);
	}
	
	public void setThings(List<Stat> stats){
		myStats = stats;
	}
	
	public List<Stat> getThings(){
		return myStats;
	}
	
	public void setStat(String name, Double value){
		this.getStat(name).setValue(value);
	}
	
	public Double getValue(String name){
		return this.getStat(name).getValue();
	}
	
	public Stat getStat(String name){
		for(Stat s : myStats){
			if(s.getName().equals(name))
				return s;
		}
		return null;
	}
	
	public StatCollection getStatCollection(String name){
		StatCollection toReturn = (StatCollection) this.getStat(name);
		if(toReturn.getValue()==null)
			return toReturn;
		return null;
	}

	@Override
	public Double getValue() {
		// If this returns null, know must dig deeper.
		return null;
	}

	@Override
	public void setValue(Double d) {
		// do nothing		
	}

}
