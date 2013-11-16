package model;

import java.util.List;

import model.tile.Tile;
import model.unit.Unit;

public abstract class Move extends Ability{
	
	private Tile myTarget;

	public Move(Unit abilityUser) {
		super(abilityUser);
	}
	
	public abstract List<Tile> getValidTiles();
	
	@Override
	public void prepAbility(){
		myTarget = myUnit.getMap().getTargetTile(getValidTiles());
		useAbility();
	}
	
	@Override
	public void useAbility(){
		double cost = canMoveToTile(myTarget);
		if(cost>0){
			myUnit.setCurrentTile(myTarget);
			myUnit.getStatCollection("Attributes").setStat("Stamina", 
					myUnit.getStatCollection("Attributes").getValue("Stamina")-cost);
		}
	}
	
	public abstract double canMoveToTile(Tile dest);
	// Can use this to loop through map and see which tiles are valid points for movement.

}
