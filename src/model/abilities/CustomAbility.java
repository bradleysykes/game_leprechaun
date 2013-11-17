package model.abilities;

import java.util.*;

import model.Ability;
import model.Effect;
import model.effects.ModifyAttribute;
import model.things.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class CustomAbility extends Ability {
	
	protected List<Unit> myTargets = new ArrayList<Unit>();
	protected List<Effect> myEffects = new ArrayList<Effect>();

	public CustomAbility(String name, Unit abilityUser) {
		super(name, abilityUser);
		this.addStat(new Stat("Range", Math.floor(abilityUser.getStatCollection("Attributes").getValue("Attack Range"))));
		this.addStat(new Stat("Radius", 0.0));
		this.addStat(new ModifyAttribute("Stat Buff","Health"));
	}
	
	public void addEffect(Effect e){
		myEffects.add(e);
	}

	@Override
	public void prepAbility() {
		myUnit.getPlayer().getController().chooseTile(myUnit.getCurrentTile().getTiles(this.getValue("Radius")));
	}

	@Override
	public void useAbility() {
		if(!myValid) return;
		for(Tile t : myTile.getTiles(this.getValue("Radius")))
			myTargets.addAll(t.getUnits());
		for(Effect effect : myEffects){
			for(Unit target : myTargets){
				effect.enact(target);
			}
		}	
		myValid = false;
	}

}
