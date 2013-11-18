package engine;

import data.GameElements;

public class GameLoader  {
	
	private GameEngine myGameEngine;
	private GameElements myGameElements;
	
	public GameLoader(GameElements gameElements, GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myGameElements = gameElements;
	}
	
	public void loadGame() {
		myGameEngine.removeObjects("tile", GameTileObject.getCollisionID());
		myGameEngine.removeObjects("unit", GameUnitObject.getCollisionID());
		
		//load here when.. still need image information from gamedata
	}
	
}
