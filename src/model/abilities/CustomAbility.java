package model.abilities;

import java.util.*;

import engine.GameEngine;

import model.Ability;
import model.Effect;
import model.Effects;
import model.effects.ModifyAttribute;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class CustomAbility extends Ability {
	
	protected List<Unit> myTargets = new ArrayList<Unit>();

	public CustomAbility(String name, Unit abilityUser, double range, double radius) {
		super(name, abilityUser);
		//this.addStat(new Stat("Range", Math.floor(abilityUser.getStatCollection("Attributes").getValue("Attack Range"))));
		//this.addStat(new Stat("Radius", 0.0));
		this.addStat(new Stat("Range", range));
		this.addStat(new Stat("Radius", radius));
		this.addStat(new Effects());
	}
	
	public void addEffect(Effect e){
		((Effects) this.getStat("Effects")).addEffect(e);
	}

	@Override
	public void useAbility() {
		if(!myValid) return;
		myTargets.clear();
		for(Tile t : myUnit.getMap().getTilesInRadius(this.getValue("Radius"),myTargetTile))
			myTargets.addAll(t.getUnits());
		for(Effect effect : ((Effects) this.getStat("Effects")).getEffects()){
			for(Unit target : myTargets){
				effect.enact(target);
			}
		}	
		myValid = false;
	}

	@Override
	public void requestEngineInput(GameEngine myGameEngine) {
		myGameEngine.highlightTiles(myUnit.getMap().getTilesInRadius
				(this.getValue("Range"),myUnit.getCurrentTile()));
	}
	
	@Override 
	public CustomAbility copy(Unit u){
		CustomAbility toReturn = new CustomAbility(this.getName(),myUnit,
				this.getValue("Range"),this.getValue("Radius"));
		for(Effect e : ((Effects) this.getStat("Effects")).getEffects())
			toReturn.addEffect(e.copy());
		return toReturn;
	}

}
