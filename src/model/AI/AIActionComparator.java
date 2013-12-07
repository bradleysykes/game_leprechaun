package model.AI;

import java.util.Comparator;

public class AIActionComparator implements Comparator<AIAction> {

	@Override
	public int compare(AIAction arg0, AIAction arg1) {
		return (int) (arg0.getEfficiency() - arg1.getEfficiency());
	}

}
