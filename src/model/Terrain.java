package model;

import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class Terrain extends StatCollection implements ModelConstants {
	
	public Terrain(){
		super("Terrain","Plains");
		this.addStat(new Stat("Magnitude",DEFAULT_DOUBLE));
	}
	
	public Terrain(Terrain stored){
		super("Terrain");
		this.setID(stored.getID());
		this.addStat(new Stat("Magnitude",stored.getValue("Magnitude")));
	}
	
	public double modifyUnit(Unit unit){
		return (Double) this.getValue("Magnitude");
	}

}
