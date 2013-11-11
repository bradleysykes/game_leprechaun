package model;

public class Attack extends Ability{

	public Attack(Unit abilityUser) {
		super(abilityUser);
	}
	
	@Override
	public int useAbility(){
		if (myRange > 0){
			Unit enemyUnit = myUnit.getTarget(myRange);
			
		}
		return 0;
	}

}
