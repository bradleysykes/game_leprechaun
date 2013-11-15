package model.unit;

import model.Attack;
import model.Attributes;
import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.things.StringThing;
import model.things.Thing;
import model.things.ThingsThing;
import model.tile.Tile;
import java.util.*;

public class Unit extends ThingsThing implements ModelConstants {
	
	private GameMap myMap;
	private Player myPlayer;
	private Tile myCurrentTile;
	
	//private Movement myMovement;
	//private Attack myAttack;
	//private Spawner mySpawner;
	//private Abilities myAbilities;
	
	List<Thing> myThings = new ArrayList<Thing>();
	
	public Unit(String name, Player player, GameMap map){
		super("Unit","Thing");
		this.addThing(new StringThing("Name"));
		this.addThing(new Attributes());
		//this.addThing(new Attack());
		//this.addThing(new BudgetMove());
		//this.addThing(new Spawner());
		//this.addThing(new Abilities());
		myPlayer = player;
		myMap = map;
	}
	
	public Thing getThing(String name){
		for(Thing t : myThings){
			if(t.getName().equals(name))
				return t;
		}
		return null;
	}
	
	public List<Thing> getThings(){
		return myThings;
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
	
//	public void setAttributes(){
//		myAttributes.add(a.)
//	}
	
	public Attributes getAttributes(){
		return (Attributes) this.getThing("Attributes");
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
	
	public void useAbility(String ability){
		//this.getThing(ability).prepAbility();
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
		return (String) this.getValue("Name");
	}

	public void setName(String myName) {
		this.setValue("Name",myName);
	}
	
	public boolean equals(Unit other){
		return (myName.equals(other.getName()) && myPlayer.equals(other.getName()));
	}
	
}
