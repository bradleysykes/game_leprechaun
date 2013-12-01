package gae.dialogues;

import gae.Controller;
import gae.viewitems.ViewItem;

import java.util.List;

import model.Condition;
import model.Player;
import model.stats.StatCollection;
import model.unit.Unit;

public class WaypointParameterSetter implements IConditionParameterSetter {

	public WaypointParameterSetter(Controller myController) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StatCollection> getFirstVariableOptions(int playerNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatCollection> getSecondVariableOptions(int var1Num) {
		// TODO Auto-generated method stub
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
