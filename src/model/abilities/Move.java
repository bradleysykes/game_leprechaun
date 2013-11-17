package model.abilities;

import java.util.List;

import model.Ability;
import model.tile.Tile;
import model.unit.Unit;

public abstract class Move extends Ability{

	public Move(String name, Unit abilityUser) {
		super(name,abilityUser);
	}
	
	public abstract List<Tile> getValidTiles();
	
	public abstract double canMoveToTile(Tile dest);
	// Can use this to loop through map and see which tiles are valid points for movement.

}
