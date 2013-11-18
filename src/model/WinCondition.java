package model;

import model.condition.Defeat;
import model.things.Stat;

public class WinCondition extends Condition {
	
	public WinCondition(Player p){
		super("Win Condition", p);
		//this.addStat(new Defeat());
	}

	@Override
	public boolean check() {
		for(Stat s : this.getStats()){
			Condition condition = (Condition) s;
			if(condition.check() == false)
				return false;
		}
		return true;
	}

}
