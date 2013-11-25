package model.AI;

import java.util.PriorityQueue;

import model.Player;

public class AIOpponent extends Player{
	
	PriorityQueue<AIAction> myRankedActions = new PriorityQueue<AIAction>();
	
	public void rankAndPerformAction(){
		
		AIAction bestOption = myRankedActions.poll();	
		bestOption.getAbility().useAbility();
	}
	
	public void refresh(){
		myRankedActions.clear();
		super.refresh();
	}

}
