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

	public void setGameEngine(GameEngine ge){
		myGameEngine = ge;
	}

	public void setAbility(Ability a){
		myQueuedAbility = a;
		myQueuedAbility.requestEngineInput(myGameEngine);
	}

	public void useAbility(Tile t){
		if(!(myQueuedAbility == null)){
			myQueuedAbility.setTargetTile(t);
			myQueuedAbility.useAbility();
		}
	}

	public void useAbility(Unit u){
		if(!(myQueuedAbility == null)){
			myQueuedAbility.setTargetUnit(u);
			myQueuedAbility.useAbility();
		}
	}

	public void refresh(){
		for(Player p : myPlayers){
			if(p.checkWinningCondition()){
				myGameEngine.declareWinner(p);
			}
			p.refresh();
		}
		myQueuedAbility = null;
	}

	public List<Player> getPlayers(){
		return myPlayers;
	}

	public void destroyUnit(Unit unit) {
		myGameEngine.destroyUnit(unit);
	}

	public void spawnUnit(Unit u){
		myGameEngine.spawnUnit(u);
	}

}
