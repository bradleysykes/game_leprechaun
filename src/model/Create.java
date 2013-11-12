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
				if (unit == myUnit){
					return true;
				}
			}
		}
		return false;
	}
	
}