package gae.dialogues;

import gae.Controller;
import gae.viewitems.ViewItem;

import java.util.List;

import model.Condition;
import model.Player;
import model.unit.Unit;

public class WaypointParameterSetter implements IConditionParameterSetter {

	public WaypointParameterSetter(Controller myController) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ViewItem> getFirstVariableOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewItem> getSecondVariableOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewItem> getThirdVariableOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Condition> getCondition(List<Player> players, Unit goal) {
		// TODO Auto-generated method stub
		return null;
	}
}
