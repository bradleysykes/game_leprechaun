package model.condition;

import model.Condition;
import model.Player;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class Waypoint extends Condition {
	
	public Waypoint(){
		super("Waypoint","",null);
	}

	public Waypoint(String wayfarer, Player p, Tile destination) {
		super("Waypoint",wayfarer, p);
		this.addStat(new Stat("X",(double) destination.getX()));
		this.addStat(new Stat("Y",(double) destination.getY()));
	}
	
	@Override
	public boolean check(){
		for(Unit u : myPlayer.getAllUnits()){
			if(u.getID().equals(this.getID())){
				if((double) u.getCurrentTile().getX() == this.getValue("X")){
					if((double) u.getCurrentTile().getY() == this.getValue("Y"))
						return true;
				}
			}
		}
		return false;
	}

}
