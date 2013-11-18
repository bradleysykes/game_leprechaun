package model;

import engine.GameEngine;
import java.util.*;

import model.tile.Tile;

public class Model {
	private List<Player> myPlayers = new ArrayList<Player>();
	private GameMap myMap;
	private GameEngine myGameEngine;
	private Ability myQueuedAbility;

	public Model() {

	}
	
	public void addPlayer(Player p){
		myPlayers.add(p);
	}
	
	public void setMap(GameMap map){
		myMap = map;
	}
	
	public void setGame(GameEngine ge){
		myGameEngine = ge;
	}
	
	public void setAbility(Ability a){
		myQueuedAbility = a;
	}
	
	public void useAbility(Tile t){
		myQueuedAbility.setTargetTile(t);
		myQueuedAbility.useAbility();
	}

//	public Unit chooseUnit(Collection<Tile> validTiles){
//		return null;
//	}
	
	public Tile chooseTile(Collection<Tile> validTiles){
		// Pass this information to Game Engine for appropriate tile to be selected.
		// myGameEngine.selectTile(validTiles);
		return null;
	}
	
}
