package model.unit;

import model.Abilities;
import model.Ability;
import model.Attributes;
import model.GameMap;
import model.ModelConstants;
import model.Player;
import model.Resources;
import model.stats.Stat;
import model.stats.StatCollection;
import model.tile.Tile;

/**
 * Unit which has behaviors / limitations controlled through modification
 * of the objects it is composed of: Attributes and Abilities.
 * @author Timo and John
 */
public class Unit extends StatCollection implements ModelConstants {
	
	private GameMap myMap;
	private Player myPlayer;
	private Tile myCurrentTile;

	public Unit(String id, Player player, Tile tile) {
		super("Unit",id);
		myPlayer = player;
		myCurrentTile = tile;
		myMap = tile.getMap();
		this.addStat(new Attributes());
		this.addStat(new Abilities(this));
		// Resources object to track cost of the unit
		this.addStat(new Resources());
	}
	
	public Unit(Unit stored, Player p, Tile t){
		super("Unit",stored.getID());
		myPlayer = p;
		myCurrentTile = t;
		myMap = t.getMap();
		this.addStat(new Attributes((Attributes) stored.getStatCollection("Attributes")));
		this.addStat(new Abilities(this,(Abilities) stored.getStatCollection("Abilities")));
		this.addStat(new Resources((Resources) stored.getStatCollection("Resources")));
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
	
	public void setCurrentTile(Tile t){
		if(myCurrentTile.containsUnit(this))
			myCurrentTile.removeUnit(this);
		myCurrentTile = t;
		myCurrentTile.addUnit(this);
		this.setMap(t.getMap());
	}
	
	public Tile getCurrentTile(){
		return myCurrentTile;
	}
	
	public boolean equals(Unit other){
		return (this.getID().equals(other.getID()) && myPlayer.equals(other.getPlayer()));
	}
	
	public void refresh(){
		for (Stat s : this.getStatCollection("Abilities").getStats()){
			Ability a = (Ability) s;
			a.refresh();
		}
		Attributes a = (Attributes) this.getStatCollection("Attributes");
		a.refresh();
	}
	
}
