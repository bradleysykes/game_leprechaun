package model;

import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class Terrain extends StatCollection implements ModelConstants {
	
	public Terrain(){
		super("Terrain","Plains");
		this.addStat(new Stat("Magnitude",DEFAULT_DOUBLE));
	}
	
	public double modifyUnit(Unit unit){
		//return unit.getAttributes.alter(myAttributeImpacted,myMagnitude);
		return (Double) this.getValue("Magnitude");
	}

}
