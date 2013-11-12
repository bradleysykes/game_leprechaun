package model.unit;

import model.Attributes;
import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.tile.Tile;
import java.util.*;

public class Unit implements ModelConstants {
	
	private String myName;
	private GameMap myMap;
	private Player myPlayer;
	private Attributes myAttributes = new Attributes();
	//private Movement myMovement;
	//private Attack myAttack;
	//private Spawner mySpawner;
	//private Abilities myAbilities;
	private Tile myCurrentTile;
	
	public Unit(String name, Player player, GameMap map){
		setName(name);
		myPlayer = player;
		myMap = map;
	}

	public void setAttributes(double health, double attack, double defense, double stamina){
		
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
	
	public void setAttributes(Attributes a){
		myAttributes = a;
	}
	
	public Attributes getAttributes(){
		return myAttributes;
	}
	
	public void setMapPosition(int newX, int newY){
		myCurrentTile = myMap.getTile(newX,newY);
	}
	
	public void setCurrentTile(Tile t){
		myCurrentTile = t;
	}
	
	public Tile getCurrentTile(){
		return myCurrentTile;
	}
	
	public void useAbility(int index){
		//myAbilities.use(index);
	}
	
	public Unit getTarget(int range){
		List<Tile> validTiles = new ArrayList<Tile>();
		for (int i = myCurrentTile.getX() - range; i <= myCurrentTile.getX() + range; i++){
			for (int j = myCurrentTile.getY() - range; i <= myCurrentTile.getY() + range; j++){
				validTiles.add(myMap.getTile(i, j));
			}
		}
		return myMap.getTargetUnit(validTiles);
	}

	public String getName() {
		return myName;
	}

	public void setName(String myName) {
		this.myName = myName;
	}
	
	public boolean equals(Unit other){
		return (myName.equals(other.getName()) && myPlayer.equals(other.getName()));
	}
	
}
