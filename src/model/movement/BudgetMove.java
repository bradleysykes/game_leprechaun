package model.movement;

import java.util.ArrayList;
import java.util.List;

import model.GameMap;
import model.abilities.Move;
import model.tile.Tile;
import model.unit.Unit;

public class BudgetMove extends Move {
	
	public BudgetMove(Unit abilityUser){
		super("Budget Move", abilityUser);
	}
	
	@Override
	public void useAbility(){
		double newBudget = canMoveToTile(myTargetTile);
		if(newBudget>=0){
			myUnit.setCurrentTile(myTargetTile);
			myUnit.getStatCollection("Attributes").setStat("Stamina", newBudget);
		}
		if(newBudget==0)
			myValid = false;
	}
	
	@Override
	public double canMoveToTile(Tile dest){
		return pathFinder(myUnit.getCurrentTile().getX(),myUnit.getCurrentTile().getY(),
				dest.getX(),dest.getY(),myUnit.getMap(), myUnit.getStatCollection("Attributes").getValue("Stamina"));
	}
	
	@Override
	public List<Tile> getValidTiles(){
		List<Tile> validTiles = new ArrayList<Tile>();
		for(Tile t : myUnit.getMap().getAllTiles()){
			if(canMoveToTile(t)>=0){
				validTiles.add(t);
			}
		}
		return validTiles;
	}
	
	// If there is a path to the destination, returns unit's new budget.
	// If not, returns -1.
	public double pathFinder(int currentX, int currentY, int destX, int destY, GameMap map, double budget){
		if(currentX == destX && currentY == destY)
			return budget;
		if(budget < 0)
			return -1;
		for(int r = -1; r <= 1; r++){
			for(int c = -1; c <= 1; c++){
				if(r!=c && r!=-c){
					int newX = currentX+r;
					int newY = currentY+c;
					if(!map.contains(newX, newY)) continue;
					double cost = map.getTile(newX, newY).getValue("Passability");
					if(cost <= 0)
						continue;
					double check = pathFinder(newX,newY,destX,destY,map,budget-cost);
					if(check>=0)
						return check;
				}
			}
		}
		return -1;
	}
	
	public BudgetMove copy(Unit u){
		return new BudgetMove(u);
	}
}
