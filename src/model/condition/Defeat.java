package model.condition;

import model.Condition;
import model.Player;
import model.unit.Unit;

public class Defeat extends Condition {
	
	public Defeat(){
		super("Defeat", "", null);
	}

	public Defeat(String target, Player p) {
		super("Defeat", target, p);
	}
	
	@Override
	public boolean check(){
		for(Player p : myPlayer.getModel().getPlayers()){
			if (!p.equals(myPlayer)){
				for(Unit u : p.getAllUnits()){
					if(u.getID().equals(this.getID()))
						return false;
				}
			}
		}
		
		return true;
	}

}
