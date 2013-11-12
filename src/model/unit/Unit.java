package model.unit;

import model.Attributes;
import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.tile.Tile;
import jgame.JGObject;

public class Unit extends JGObject implements ModelConstants {
	
	private GameMap myMap;
	private Player myPlayer;
	private Attributes myAttributes = new Attributes();
	//private Movement myMovement;
	//private Attack myAttack;
	//private Spawner mySpawner;
	//private Abilities myAbilities;
	private Tile myCurrentTile;
	
	public Unit(String name, Player player, GameMap map){
		this(name,0,0,player,map);
	}
	
	public Unit(String name, double initX, double initY, Player player, GameMap map){
		this(DEFAULT_NAME, false, initX, initY, 0, DEFAULT_GRAPHIC_NAME);
		myPlayer = player;
		myMap = map;
	}

	public Unit(String name, boolean unique_id, double x, double y,
			int collisionid, String gfxname) {
		super(name, unique_id, x, y, collisionid, gfxname);
	}
	
	public void setAttributes(double health, double attack, double defense, double stamina){
		
	}
	
	public GameMap getMap(){
		return myMap;
	}
	
	public Attributes getAttributes(){
		return myAttributes;
	}
	
	public Player getPlayer(){
		return myPlayer;
	}
	
	public void setMapPosition(int newX, int newY){
		myCurrentTile = myMap.getTile(newX,newY);
	}
	
	public void moveUnit(){
		// useAbility(moveIndex);
	}
	
	public Tile getCurrentTile(){
		return myCurrentTile;
	}
	
	public void useAbility(int index){
		//myAbilities.use(index);
	}
	
	public Unit getTarget(int range){
		return myMap.getTarget(myCurrentTile,range);
	}
	
}
