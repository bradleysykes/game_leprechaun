package model;

import model.tile.Tile;
import model.unit.Unit;
import java.util.*;

public abstract class Ability{
	
	protected Unit myUnit;
	protected Parameters myParameters;
	protected Tile myTile;

	public Ability(Unit abilityUser) {
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
