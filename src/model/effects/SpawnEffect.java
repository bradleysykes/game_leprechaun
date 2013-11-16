package model.effects;

import model.Effect;
import model.unit.Unit;

public class SpawnEffect extends Effect {

	public SpawnEffect() {
		super("Spawn Effect", null);
	}
	
	public void addUnit(String unitID){
		myIDs.add(unitID);
	}

	@Override
	public void enact(Unit target) {
		// TODO Auto-generated method stub
	}

}
