package model;

import java.util.List;

import model.tile.Tile;
import model.unit.Unit;

public abstract class Move extends Ability{

	public Move(Unit abilityUser) {
		super(abilityUser);
	}
	
	public abstract List<Tile> getValidTiles();
	
	@Override
	public double useAbility(){
		Tile t = myUnit.getMap().getTargetTile(getValidTiles());
		double cost = canMoveToTile(t);
		if(cost>0){
			myUnit.setCurrentTile(t);
			myUnit.getAttributes().setStamina(myUnit.getAttributes().getStamina()-cost);
		}
		return cost;
	}
	
	public abstract double canMoveToTile(Tile dest);
	// Can use this to loop through map and see which tiles are valid points for movement.

}
