package gae.dialogues;

import gae.viewitems.ViewItem;

import java.util.List;

import model.Condition;
import model.Player;
import model.unit.Unit;

public interface IConditionParameterSetter {

	public abstract List<ViewItem> getFirstVariableOptions();
	
	public abstract List<ViewItem> getSecondVariableOptions();
	
	public abstract List<ViewItem> getThirdVariableOptions();
	
	public abstract List<Condition> getCondition(List<Player> players, Unit goal);
}
