package model;

import engine.GameEngine;
import java.util.*;

import model.tile.Tile;

public class Controller {
	private List<Player> myPlayers = new ArrayList<Player>();
	private GameMap myMap;
	private GameEngine myGame;
	private Ability myQueuedAbility;

	public Controller() {
		
	}
	
	public void addPlayer(Player p){
		myPlayers.add(p);
	}
	
	public void setMap(GameMap map){
		myMap = map;
	}
	
	public void setGame(GameEngine ge){
		myGame = ge;
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
		return null;
	}
	
}
