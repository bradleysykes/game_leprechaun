package model;

import engine.GameEngine;
import model.stats.StatCollection;
import model.tile.Tile;
import model.unit.Unit;

public abstract class Ability extends StatCollection {
	
	protected Unit myUnit;
	protected Tile myTargetTile;
	protected Unit myTargetUnit;
	protected boolean myValid = true;

	public Ability(String name, Unit abilityUser) {
		super(name);
		myUnit = abilityUser;
		this.refresh();
	}
	
	public Ability(String name, Unit abilityUser, String referenceType){
		super(name,"",referenceType);
		myUnit = abilityUser;
		this.refresh();
	}
	
	public void setUnit(Unit u){
		myUnit = u;
	}
	
	public Unit getUnit(){
		return myUnit;
	}
	
	public abstract void useAbility();
	
	public void setTargetTile(Tile t){
		myTargetTile = t;
	}
	
	public void setTargetUnit(Unit u){
		myTargetUnit = u;
	}
	
	public void refresh(){
		myValid = true;
	}
	
	public boolean isValid(){
		return myValid;
	}

	public abstract void requestEngineInput(GameEngine myGameEngine);
	
	public abstract Ability copy(Unit user);
}
