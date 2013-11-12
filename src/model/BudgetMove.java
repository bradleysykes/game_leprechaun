package model;

import model.tile.Tile;
import model.unit.Unit;

public class BudgetMove extends Move {
	
	public BudgetMove(Unit abilityUser){
		super(abilityUser);
	}
	
	public double canMoveToTile(Tile dest){
		return pathFinder(myUnit.getCurrentTile().getX(),myUnit.getCurrentTile().getY(),
				dest.getX(),dest.getY(),myUnit.getMap(),myUnit.getAttributes().getStamina());
	}
	
	// If there is a path to the destination, returns unit's new budget.
	// If not, returns -1.
	public double pathFinder(int currentX, int currentY, int destX, int destY, GameMap map, double budget){
		if(currentX == destX && currentY == destY)
			return budget;
		if(budget <= 0)
			return -1;
		for(int r = -1; r <= 1; r++){
			for(int c = -1; c <= 1; c++){
				if(r!=c && r!=-c){
					int newX = currentX+r;
					int newY = currentY+c;
					double cost = map.getTile(newX, newY).getPassability();
					if(cost == 0)
						continue;
					double check = pathFinder(currentX+r,currentY+c,destX,destY,map,budget-cost);
					if(check>0)
						return check;
				}
			}
		}
		return -1;
	}

}
