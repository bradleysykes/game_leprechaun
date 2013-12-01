package gae.dialogues;

import gae.viewitems.ViewItem;

import java.util.List;

import model.Condition;
import model.Player;
import model.stats.StatCollection;
import model.unit.Unit;

public interface IConditionParameterSetter {

	public abstract List<StatCollection> getFirstVariableOptions(int playerNum);
	
	public abstract List<StatCollection> getSecondVariableOptions(int var1Num);
	
	public abstract List<StatCollection> getThirdVariableOptions(int var2Num);
	
	public abstract Condition getCondition(Player player, StatCollection...objects);
}
