package model.unit;

import java.util.*;

import model.Attack;
import model.Attributes;
import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.things.Stat;
import model.things.StatCollection;
import model.tile.Tile;

public class Unit extends StatCollection implements ModelConstants {
	
	private GameMap myMap;
	private Player myPlayer;
	private Tile myCurrentTile;
	
	//private Movement myMovement;
	//private Attack myAttack;
	//private Spawner mySpawner;
	//private Abilities myAbilities;
	
	public Unit(String name, Player player, GameMap map){
		super("Unit","Soldier");
		this.addStat(new Attributes());
		//this.addThing(new Attack());
		//this.addThing(new BudgetMove());
		//this.addThing(new Spawner());
		//this.addThing(new Abilities());
		myPlayer = player;
		myMap = map;
	}
	
	public void setMap(GameMap map){
		myMap = map;
	}
	
	public GameMap getMap(){
		return myMap;
	}
	
	public void setPlayer(Player player){
		myPlayer = player;
	}
	
	public Player getPlayer(){
		return myPlayer;
	}
	
//	public void setAttributes(){
//		myAttributes.add(a.)
//	}
	
	public void setMapPosition(int newX, int newY){
		myCurrentTile = myMap.getTile(newX,newY);
	}
	
	public void setCurrentTile(Tile t){
		myCurrentTile = t;
	}
	
	public Tile getCurrentTile(){
		return myCurrentTile;
	}
	
	public void useAbility(String ability){
		//this.getThing(ability).prepAbility();
	}

	public String getName() {
		return (String) this.getID();
	}

	public void setName(String id) {
		this.setID(id);
	}
	
	public boolean equals(Unit other){
		return (myID.equals(other.getID()) && myPlayer.equals(other.getPlayer()));
	}
	
}
