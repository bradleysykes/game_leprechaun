package gae.dialogues;

import gae.Controller;
import gae.viewitems.ViewItem;

import java.util.ArrayList;
import java.util.List;

import model.Condition;
import model.Player;
import model.condition.Defeat;
import model.unit.Unit;

public class DefeatParameterSetter implements IConditionParameterSetter {
	private Controller myController;
	private List<Player> myPlayers;
	private List<Player> myWOSelected;

	public DefeatParameterSetter(Controller controller) {
		myController = controller;
		myPlayers = controller.getPlayers();
		myWOSelected = new ArrayList<Player>();
	}

	@Override
	public List<Player> getFirstVariableOptions(int playerNum) {
		myWOSelected = new ArrayList<Player>();
		for (int i=0; i<myPlayers.size(); i++) {
			if(i!=playerNum) {
				myWOSelected.add(myPlayers.get(i));
			}
		}
		return myWOSelected;
	}

	@Override
	public List<Unit> getSecondVariableOptions(int var1Num) {
		Player p =myWOSelected.get(var1Num);
		return p.getAllUnits();
	}

	@Override
	public List<ViewItem> getThirdVariableOptions(int var2Num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition getCondition(Player player, Unit goal) {	
		return new Defeat(goal.getID(), player);
	}

}
