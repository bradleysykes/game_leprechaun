package model;

import model.stats.StatCollection;
import model.unit.Unit;

public abstract class Effect extends StatCollection{

	public Effect(String name, String s) {
		super(name,s);		
	}

	public abstract void enact(Unit target);
		
}
