package model;

import engine.GameEngine;
import java.util.*;

import model.tile.Tile;
import model.unit.Unit;

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
	
	public static void useAbility(Unit u){
		myQueuedAbility.setTargetUnit(u);
		myQueuedAbility.useAbility();
	}
	
	public void chooseString(){
		//
	}
	
}
