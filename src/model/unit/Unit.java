package model.unit;

import java.awt.Point;

import model.Abilities;
import model.Ability;
import model.Attributes;
import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.stats.Stat;
import model.stats.StatCollection;
import model.tile.Tile;

/**
 * Unit which has behaviors / limitations controlled through modification
 * of the objects it is composed of: Attributes and Abilities.
 * @author Timo and John
 *
 */
public class Unit extends StatCollection implements ModelConstants {
	
	private GameMap myMap;
	private Player myPlayer;
	private Tile myCurrentTile;
	private int myX,  myY;
	
	//change name to id?
	public Unit(String id, Player player, GameMap map){
		super("Unit",id);
		this.addStat(new Attributes());
		this.addStat(new Abilities(this));
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
		myX = newX;
		myY = newY;
		myCurrentTile = myMap.getTile(newX,newY);
	}
	
	public Point getMapPosition(){
		return new Point(myX,myY);
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

	//don't need this! creates an infinite loop!
//	public String getID() {
//		return (String) this.getID();
//	}

	public void setID(String id) {
		this.setID(id);
	}
	
	public boolean equals(Unit other){
		return (this.getID().equals(other.getID()) && myPlayer.equals(other.getPlayer()));
	}
	
	public void refresh(){
		for (Stat s : this.getStatCollection("Abilities").getStats()){
			Ability a = (Ability) s;
			a.refresh();
		}
	}

	
}
