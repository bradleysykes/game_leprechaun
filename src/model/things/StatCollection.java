package model.things;

import java.util.ArrayList;
import java.util.List;

public class StatCollection extends Stat {
	
	protected String myID;
	
	public StatCollection(String name){
		super(name,null);
		myID = DEFAULT_STRING;
	}
	
	public StatCollection(String name, String title){
		this(name);
		myID = title;
	}
	
	protected List<Stat> myStats = new ArrayList<Stat>();
	
	public String getID(){
		return myID;
	}
	
	public void setID(String id){
		myID = id;
	}
	
	public void addStat(Stat t){
		myStats.add(t);
	}
	
	public void removeStat(Stat t){
		myStats.remove(t);
	}
	
	public void setStats(List<Stat> stats){
		myStats = stats;
	}
	
	public List<Stat> getStats(){
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
