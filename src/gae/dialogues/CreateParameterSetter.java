package gae.dialogues;

import gae.control.Controller;
import gae.viewitems.ViewItem;

import java.util.ArrayList;
import java.util.List;

import model.Condition;
import model.Player;
import model.condition.Create;
import model.stats.StatCollection;
import model.unit.Unit;

public class CreateParameterSetter implements IConditionParameterSetter {
	private Controller myController;
	
	public CreateParameterSetter(Controller controller) {
		myController = controller;
	}

	@Override
	public List<StatCollection> getFirstVariableOptions(int playerNum) {
		List<Unit> unitTypes = myController.getUnitTypes();
		List<StatCollection> toReturn = new ArrayList<StatCollection>();
		for (Unit u:unitTypes) {
			toReturn.add(u);
		}
		return toReturn;
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
	public Condition getCondition(Player player, StatCollection...objects) {
		String unitName = objects[0].getName();
		return new Create(unitName, player);
	}

}
