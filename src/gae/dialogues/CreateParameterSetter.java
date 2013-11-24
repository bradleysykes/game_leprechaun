package gae.dialogues;

import gae.Controller;
import gae.viewitems.ViewItem;

import java.util.List;

import model.Condition;
import model.Player;
import model.condition.Create;
import model.unit.Unit;

public class CreateParameterSetter implements IConditionParameterSetter {
	private Controller myController;
	
	public CreateParameterSetter(Controller controller) {
		myController = controller;
	}

	@Override
	public List<Player> getFirstVariableOptions(int playerNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Unit> getSecondVariableOptions(int var1Num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewItem> getThirdVariableOptions(int var2Num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition getCondition(Player players, Unit goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
