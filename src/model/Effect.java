package model;

import model.stats.StatCollection;
import model.unit.Unit;

public abstract class Effect extends StatCollection{

	public Effect(String name){
		super(name);
	}
	
	public Effect(String name, String id) {
		super(name,id);		
	}
	
	public Effect(String name, String id, String referenceType){
		super(name,id,referenceType);
	}
	
	public abstract void enact(Unit target);
	
	public abstract Effect copy();
		
}
