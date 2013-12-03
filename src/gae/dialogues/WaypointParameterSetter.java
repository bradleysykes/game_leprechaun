package gae.dialogues;

import gae.Controller;
import gae.viewitems.ViewItem;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import model.Condition;
import model.GameMap;
import model.Player;
import model.condition.Waypoint;
import model.stats.StatCollection;
import model.tile.Tile;
import model.unit.Unit;

public class WaypointParameterSetter implements IConditionParameterSetter {

	private Controller myController;
	private GameMap myMap;
	public WaypointParameterSetter(Controller controller) {
		myController = controller;
	}

	@Override
	public List<StatCollection> getFirstVariableOptions(int playerNum) {
		List<Unit> units = myController.getPlayers().get(playerNum).getAllUnits();
		List<StatCollection> toReturn = new ArrayList<StatCollection>();
		for (Unit u:units) {
			toReturn.add(u);
		}
		return toReturn;
	}

	@Override
	public List<StatCollection> getSecondVariableOptions(int var1Num) {
		myMap = myController.getMap();
		List<StatCollection> myList = new ArrayList<StatCollection>();
		for (int x = 0; x<myMap.getSizeX(); x++) {
			for (int y = 0; y<myMap.getSizeY(); y++) {
				myList.add(new TilePosition(x+"X"+y, x, y));
			}
		}
		return myList;
	}

	@Override
	public List<StatCollection> getThirdVariableOptions(int var2Num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition getCondition(Player players, StatCollection...objects) {
		String objectiveUnit = objects[0].getName();
		TilePosition tp = (TilePosition) objects[1];
		Tile selectedTile = myMap.getTile(tp.getX(), tp.getY());
		Waypoint p = new Waypoint(objectiveUnit, players, selectedTile);
		return p;
	}
	
	private class TilePosition extends StatCollection {
		private int myX;
		private int myY;
		public TilePosition(String name, int x, int y) {
			super(name);
			myX = x;
			myY = y;
		}
		public int getX(){
			return myX;
		}
		public int getY(){
			return myY;
		}
	}
}
