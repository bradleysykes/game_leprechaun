package model;

import jgame.JGObject;

public class Unit extends JGObject implements ModelConstants {
	
	private Map myMap;
	private Player myPlayer;
	private Attributes myAttributes = new Attributes();
	//private Movement myMovement;
	//private Attack myAttack;
	//private Spawner mySpawner;
	//private Abilities myAbilities;
	private double myMapX=0;
	private double myMapY=0;
	
	public Unit(){
		this(0,0);
	}
	
	public Unit(double initX, double initY){
		this(DEFAULT_NAME, false, initX, initY, 0, DEFAULT_GRAPHIC_NAME);
	}

	public Unit(String name, boolean unique_id, double x, double y,
			int collisionid, String gfxname) {
		super(name, unique_id, x, y, collisionid, gfxname);
	}
	
	public void setAttributes(double health, double attack, double defense, double stamina){
		
	}
	
	public void setMapPosition(double newX, double newY){
		myMapX = newX;
		myMapY = newY;
	}
	
	public void moveUnit(){
		// useAbility(moveIndex);
	}
	
	public void useAbility(int index){
		//myAbilities.use(index);
	}
	

}
