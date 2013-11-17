package model.unit;

import model.Attributes;
import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.abilities.Attack;
import model.movement.BudgetMove;
import model.things.StatCollection;
import model.tile.Tile;

public class Unit extends StatCollection implements ModelConstants {
	
	private GameMap myMap;
	private Player myPlayer;
	private Tile myCurrentTile;
	
	public Unit(String name, Player player, GameMap map){
		super("Unit","Soldier");
		this.addStat(new Attributes());
		this.addStat(new Attack(this));
		this.addStat(new BudgetMove(this));
		//this.addStat(new Spawner());
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

	public String getID() {
		return (String) this.getID();
	}

	public void setID(String id) {
		this.setID(id);
	}
	
	public boolean equals(Unit other){
		return (this.getID().equals(other.getID()) && myPlayer.equals(other.getPlayer()));
	}
	
}
