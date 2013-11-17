package model;

import model.things.StatCollection;
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
	
	public void prepAbility(){
		myUnit.getPlayer().getController().setAbility(this);
	}
	
	public abstract void useAbility();
	
	public void setTargetTile(Tile t){
		myTile = t;
	}
	
}
