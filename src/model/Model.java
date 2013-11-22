package model;

import engine.GameEngine;
import java.util.*;

import model.tile.Tile;

public class Model {
	private List<Player> myPlayers = new ArrayList<Player>();
	private GameMap myMap;
	private GameEngine myGameEngine;
	private static Ability myQueuedAbility;

	public Model(GameEngine ge) {
		myGameEngine = ge;
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
	
	public static void useAbility(Tile t){
		myQueuedAbility.setTargetTile(t);
		myQueuedAbility.useAbility();
	}

//	public Unit chooseUnit(Collection<Tile> validTiles){
//		return null;
//	}
	
	public void chooseTile(List<Tile> validTiles){
		myGameEngine.highlightTiles(validTiles);
	}
	
}
