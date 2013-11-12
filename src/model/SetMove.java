package model;

import java.util.ArrayList;
import java.util.List;

import model.tile.Tile;
import model.unit.Unit;

// Will require designer to select points relative to the units current position
// that are viable points to move to...

public class SetMove extends Move {
	
	private List<Tile> myValidTiles = new ArrayList<Tile>();
	
	public SetMove(Unit abilityUser) {
		super(abilityUser);
	}

	@Override
	public double canMoveToTile(Tile dest) {
		return 0;
	}

	@Override
	public List<Tile> getValidTiles() {
		return myValidTiles;
	}

	@Override
	public double prepAbility() {
		return 0;
	}

}
