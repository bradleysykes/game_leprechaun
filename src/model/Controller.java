package model;

import engine.GameEngine;
import java.util.*;

import model.tile.Tile;
import model.unit.Unit;

public class Controller {
	private List<Player> myPlayers = new ArrayList<Player>();
	private GameMap myMap;
	private GameEngine myGame;

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

	public Unit chooseUnit(Collection<Tile> validTiles){
		return null;
	}
	
	public Tile chooseTile(Collection<Tile> validTiles){
		return null;
	}
	
}
