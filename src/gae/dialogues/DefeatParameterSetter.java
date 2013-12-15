package gae.dialogues;

import gae.control.Controller;
import gae.viewitems.ViewItem;

import java.util.ArrayList;
import java.util.List;

import model.Condition;
import model.Player;
import model.condition.Defeat;
import model.stats.StatCollection;
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
	public List<StatCollection> getFirstVariableOptions(int playerNum) {
		myWOSelected = new ArrayList<Player>();
		for (int i=0; i<myPlayers.size(); i++) {
			if(i!=playerNum) {
				myWOSelected.add(myPlayers.get(i));
			}
		}
		List<StatCollection> toReturn = new ArrayList<StatCollection>();
		for (Player p:myWOSelected) {
			toReturn.add(p);
		}
		return toReturn;
	}

	@Override
	public List<StatCollection> getSecondVariableOptions(int var1Num) {
		Player p =myWOSelected.get(var1Num);
		List<StatCollection> toReturn = new ArrayList<StatCollection>();
		for (Unit u:p.getAllUnits()) {
			toReturn.add(u);
		}
		return toReturn;
	}

	@Override
	public List<StatCollection> getThirdVariableOptions(int var2Num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition getCondition(Player player, StatCollection...objects) {
		Unit goal = (Unit) objects[1];
		return new Defeat(goal.getID(), player);
	}

}
