package model;

import java.util.List;

import model.tile.Tile;
import model.unit.Unit;

public abstract class Move extends Ability{

	public Move(String name, Unit abilityUser) {
		super(name,abilityUser);
	}
	
	public abstract List<Tile> getValidTiles();
	
	@Override
	public void prepAbility(){
		myTile = myUnit.getMap().getTargetTile(getValidTiles());
		useAbility();
	}
	
	@Override
	public void useAbility(){
		double cost = canMoveToTile(myTile);
		if(cost>0){
			myUnit.setCurrentTile(myTile);
			myUnit.getStatCollection("Attributes").setStat("Stamina", 
					myUnit.getStatCollection("Attributes").getValue("Stamina")-cost);
		}
	}
	
	public abstract double canMoveToTile(Tile dest);
	// Can use this to loop through map and see which tiles are valid points for movement.

}
