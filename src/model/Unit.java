package model;

import jgame.JGObject;

public class Unit extends JGObject {
	
	private GameMap myMap;
	private Attributes myAttributes = new Attributes();
	//private Movement myMovement;
	//private Attack myAttack;
	//private Abilities myAbilities;
	//private Spawner mySpawner;
	private int myX;
	private int myY;
	

	public Unit(String name, boolean unique_id, double x, double y,
			int collisionid, String gfxname) {
		super(name, unique_id, x, y, collisionid, gfxname);
	}
	
	public void setAttributes(double health, double attack, double defense, double stamina){
		
	}
	
	public void moveUnit(){
		//myMovement.move(this);
	}
	
	public void useAbility(){
		//myAbilities.use(1);
	}
	
	public Unit getTarget(int range){
		return myMap.getTarget(myX,myY,range);
	}
	
}
