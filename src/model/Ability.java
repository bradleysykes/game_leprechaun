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
	}
	
	public Ability(String name, Unit abilityUser, String referenceType){
		super(name,"",referenceType);
		myUnit = abilityUser;
	}
	
	public void setUnit(Unit u){
		myUnit = u;
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

	public abstract void requestEngineInput(GameEngine myGameEngine);
	
	public abstract Ability copy(Unit user);
}
