package gae.dialogues;

import gae.viewitems.ViewItem;

import java.util.List;

import model.Condition;
import model.Player;
import model.unit.Unit;

public interface IConditionParameterSetter {

	public abstract List<Player> getFirstVariableOptions(int playerNum);
	
	public abstract List<Unit> getSecondVariableOptions(int var1Num);
	
	public abstract List<ViewItem> getThirdVariableOptions(int var2Num);
	
	public abstract Condition getCondition(Player player, Unit goal);
}
