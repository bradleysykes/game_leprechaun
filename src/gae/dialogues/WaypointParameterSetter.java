package gae.dialogues;

import gae.Controller;
import gae.viewitems.ViewItem;

import java.util.ArrayList;
import java.util.List;

import model.Condition;
import model.Player;
import model.stats.StatCollection;
import model.unit.Unit;

public class WaypointParameterSetter implements IConditionParameterSetter {

	private Controller myController;
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
		return null;
	}

	@Override
	public List<StatCollection> getThirdVariableOptions(int var2Num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition getCondition(Player players, StatCollection...objects) {
		// TODO Auto-generated method stub
		return null;
	}
}
