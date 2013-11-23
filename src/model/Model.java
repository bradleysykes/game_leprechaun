package model;

import engine.GameEngine;
import java.util.*;

import model.tile.Tile;

public class Model {
	private List<Player> myPlayers = new ArrayList<Player>();
	private GameEngine myGameEngine;
	private static Ability myQueuedAbility;

	public Model(GameEngine ge) {
		myGameEngine = ge;
	}
	
	public void addPlayer(Player p){
		myPlayers.add(p);
	}
	
	public void setGame(GameEngine ge){
		myGameEngine = ge;
	}
	
	public void setAbility(Ability a){
		myQueuedAbility = a;
		myQueuedAbility.requestEngineInput(myGameEngine);
	}
	
	public static void useAbility(Tile t){
		myQueuedAbility.setTargetTile(t);
		myQueuedAbility.useAbility();
	}
	
	public static void useAbility(String s){
//		myQueuedAbility.setTargetString(s);
//		myQueuedAbility.useAbility();
	}

//	public Unit chooseUnit(Collection<Tile> validTiles){
//		return null;
//	}
	
	public void chooseTile(List<Tile> validTiles){
		myGameEngine.highlightTiles(validTiles);
	}
	
	public void chooseString(){
		//
	}
	
}
