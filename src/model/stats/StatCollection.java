package model.stats;

import java.util.ArrayList;
import java.util.List;

/**
 * Object that stores a list of Stats. By extending Stat, it may also
 * store a list of other StatCollections. This greatly simplifies the process
 * of storing the data of objects created through composition (e.g. Unit, Tile, etc.). 
 * Also stores a String ID and list of String references which is intended to allow a 
 * collection to refer to other StatCollection IDs (e.g. Spawner holds list of Units 
 * that may be spawned).
 * @author Timo and John
 *
 */
public class StatCollection extends Stat {
	
	private String myID;
	private String myReferenceType;
	protected List<String> myReferences = new ArrayList<String>();
	protected List<Stat> myStats = new ArrayList<Stat>();
	// First element in myReferences will just be a name for what the list is (e.g. Spawner will have "Items that can be spawned")
	// rest of the list is the list.

	public StatCollection(String name){
		super(name,null);
		myID = "";		// May switch to myID = null by default so know it's not a useful field.
	}

	public StatCollection(String name, String id){
		this(name);
		myID = id;
	}
	
	public StatCollection(String name, String id, String referenceTypes){
		this(name,id);
		myReferenceType = referenceTypes;
	}
	
	public String getReferenceType(){
		return myReferenceType;
	}
	
	public List<String> getReferences(){
		return myReferences;
	}
	
	public void setReferences(List<String> references){
		myReferences = references;
	}

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
		actionOnSet();
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
	
	public void actionOnSet(){
		//do nothing
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
	
	/**
	 * Creates a deep copy of the statcollection, meaning that both the new collection
	 * and all stats it contains are new objects, independent of the original.
	 * @return copied StatCollection
	 */
	@Override
	public StatCollection copy(){
		StatCollection toReturn = new StatCollection(myName,myID,myReferenceType);
		toReturn.getReferences().addAll(myReferences);
		for(Stat s : this.getStats()){
			if(s.getValue()==null){
				StatCollection sc = (StatCollection) s;
				toReturn.addStat(sc.copy());
			}
			else{
				toReturn.addStat(new Stat(s.getName(),s.getValue()));
			}
		}
		return toReturn;
	}
	
	

}
