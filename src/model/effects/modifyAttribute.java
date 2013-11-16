package model.effects;

import model.Effect;
import model.things.Stat;
import model.unit.Unit;

public class ModifyAttribute extends Effect {
	
	public ModifyAttribute(String name, String attribute) {
		this(name,attribute,DEFAULT_DOUBLE);
	}
	
	public ModifyAttribute(String name, String attribute, double power) {
		super(name,attribute);
		this.addStat(new Stat("Power",power));
	}

	@Override
	public void enact(Unit target) {
		target.getStatCollection("Attributes").setStat(myID,this.getValue("Power"));
	}
	
}
