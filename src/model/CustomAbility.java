package model;

import java.util.*;

import model.tile.Tile;
import model.unit.Unit;

public class CustomAbility extends Ability {
	protected List<Unit> myTargets = new ArrayList<Unit>();
	protected List<TargetModifier> myTargetModifiers = new ArrayList<TargetModifier>();
	protected List<Effect> myEffects = new ArrayList<Effect>();
	protected int myRange;
	protected int myRadius;

	public CustomAbility(Unit abilityUser) {
		super(abilityUser);
		myRange = (int) Math.floor(abilityUser.getStatCollection("Attributes").getValue("AttackRange"));
		myRadius = 0;
	}
	
	public void setRange(int range){
		myRange = range;
	}
	
	public void setRadius(int radius){
		myRadius = radius;
	}
	
	public void addTargetModifier(TargetModifier tm){
		myTargetModifiers.add(tm);
	}
	
	public void addEffect(Effect e){
		myEffects.add(e);
	}

	@Override
	public void prepAbility() {
		for (TargetModifier tm : myTargetModifiers)
			tm.modify();
		myUnit.getPlayer().getController().chooseTile(myUnit.getCurrentTile().getTiles(myRange));
	}

	@Override
	public void useAbility() {
		for(Tile t : myTile.getTiles(myRadius))
			myTargets.addAll(t.getUnits());
	}

}
