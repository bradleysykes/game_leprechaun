package model.effects;

import model.Effect;
import model.stats.Stat;
import model.unit.Unit;

public class ModifyAttribute extends Effect {
	
	public ModifyAttribute(String name, String attribute, double power) {
		super(name,attribute);
		this.addStat(new Stat("Power",power));
	}

	@Override
	public void enact(Unit target) {
		target.getStatCollection("Attributes").setStat(this.getID(),
				target.getStatCollection("Attributes").getValue(this.getID())+this.getValue("Power"));
		if(target.getStatCollection("Attributes").getValue("Health")<=0){
			target.getPlayer().removeUnit(target);
			target.getCurrentTile().removeUnit(target);
			target.getPlayer().getModel().destroyUnit(target);
		}
	}

	@Override
	public Effect copy() {
		return new ModifyAttribute(this.getName(),this.getID(),this.getValue("Power"));
	}
	
}
