package model;

public class Create extends Condition {
	private Unit myUnit;

	public Create(Unit goal) {
		myUnit = goal;
	}

	@Override
	public boolean check(){
		for (Tile tile : myUnit.getMap().getAllTiles()){
			for (Unit unit : tile.getUnits()){
				if (unit.equals(myUnit)){
					if (unit.isAlive()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
}