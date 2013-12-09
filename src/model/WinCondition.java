package model;

import model.stats.Stat;

public class WinCondition extends Condition {
	
	public WinCondition(Player p){
		super("Win Condition","", p);
	}

	@Override
	public boolean check() {
		if(this.getStats().size()==0)		// play for fun game...
			return false;
		for(Stat s : this.getStats()){
			Condition condition = (Condition) s;
			if(condition.check() == false)
				return false;
		}
		return true;
	}

}
