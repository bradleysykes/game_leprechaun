package data.decoder;

import model.GameMap;


public class GameElements {
    GameMap myGameMap;
    
    public GameElements(GameMap map) {
        myGameMap = map;
    }
    
    public GameMap getGameMap() {
        return myGameMap;
    }
}
