package model;

import engine.GameEngine;
import model.stats.StatCollection;
import model.tile.Tile;
import model.unit.Unit;

public abstract class Ability extends StatCollection {
	
	protected Unit myUnit;
	protected Tile myTile;
	protected boolean myValid;

	public Ability(String name, Unit abilityUser) {
		super(name);
		myUnit = abilityUser;
	}
	
	public Ability(String name, Unit abilityUser, String referenceType){
		super(name,"",referenceType);
		myUnit = abilityUser;
	}
	
	// Game Engine can either just call this on the ability of setAbility via Model.
	public void prepAbility(){
		myUnit.getPlayer().getModel().setAbility(this);
	}
	
	public abstract void useAbility();
	
	public void setTargetTile(Tile t){
		myTile = t;
	}
	
	public void refresh(){
		myValid = true;
	}

	public abstract void requestEngineInput(GameEngine myGameEngine);
}
