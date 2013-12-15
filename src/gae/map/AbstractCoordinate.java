package gae.map;

import gae.Constants;


public abstract class AbstractCoordinate implements Constants{
	
	protected int myCoordinate;
	protected GUIMap myMap;
	
	protected AbstractCoordinate(int coordinate, GUIMap map){
		myCoordinate = coordinate;
		map = myMap;
	}
	
	public int getCoordinateValue(){
		return myCoordinate;
	}
	
	protected int getAdjustedCoordinate(){
		int mapFactor = this.getMapFactor();
		if(0<myCoordinate&&myCoordinate<mapFactor*.125){
			return myCoordinate;
		}
		if(mapFactor*.125<=myCoordinate&&myCoordinate<=mapFactor*.375){
			return (int) (mapFactor*.125+(myCoordinate-mapFactor*.125)*3);
		}
		else{
			return (int) (mapFactor*.5+myCoordinate);
		}
	}
	
	public int adjustTileSize(){
		return myCoordinate/TILE_SIZE;
	}
	
	public int factorTile(){
		return myCoordinate*TILE_SIZE;
	}
	
	public abstract int getMapFactor();
	
	public abstract int getOffset();
	
	public int getTileAdjust(){
		return getObjectAdjust(TILE_SIZE);
	}
	
	public int getUnitAdjust(){
		return getObjectAdjust(UNIT_SIZE);
	}
	
	
	
	public int getObjectAdjust(int constant){
		return myMap.getMouseX()-myMap.getMouseX()%constant;
	}
}
