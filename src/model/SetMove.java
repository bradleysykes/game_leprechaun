package model;

import java.util.List;

import model.tile.Tile;
import model.unit.Unit;

// Will require designer to select points relative to the units current position
// that are viable points to move to.

public class SetMove extends Move {
	
	public SetMove(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double canMoveToTile(Tile dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tile> getValidTiles() {
		// TODO Auto-generated method stub
		return null;
	}

}
