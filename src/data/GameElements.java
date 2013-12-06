package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Condition;
import model.GameMap;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;


public class GameElements {

    protected GameMap myGameMap;
    protected List<Player> myPlayers;
    protected List<Unit> myUnitTypes;
    protected Map<Tile, String> myTileImages;
    protected Map<Unit, String> myUnitImages;
    protected List<Condition> myConditions;

    public GameElements(GameMap map, List<Player> players, Map<Tile, String> tileImages, 
                        Map<Unit, String> unitImages) {
        this(map, players);
        myTileImages = tileImages;
        myUnitImages = unitImages;
    }
    
    public GameElements(GameMap map, List<Player> players) {
        this(map);
        myPlayers = players;
    }
    
    public GameElements(GameMap map) {
        myGameMap = map;
        myPlayers = new ArrayList<Player>();
    }
    
    public GameElements() {
    
    }
    
    public void setGameMap(GameMap map) {
    	myGameMap = map;
    }
    
    public GameMap getGameMap() {
        return myGameMap;
    }
      
    public List<Player> getPlayers() {
        return myPlayers;
    }
    
    public void setPlayerList(List<Player> playerList) {
		myPlayers = playerList;
	}
    
    public void addPlayer(Player player) {
        myPlayers.add(player);
    }
    
    public void setTileImageMap(Map<Tile, String> imageMap) {
    	myTileImages = imageMap;
    }
    
    public Map<Tile, String> getTileImageMap() {
        return myTileImages;
    }
    
    public Map<Unit, String> getUnitImageMap() {
        return myUnitImages;
    }
    
    public void setUnitImageMap(Map<Unit, String> imageMap) {
        myUnitImages = imageMap;
    }
        
    public void setUnitTypes(List<Unit> unitTypes) {
    	myUnitTypes = unitTypes;
    }
    
    public List<Unit> getUnitTypes() {
    	return myUnitTypes;
    }

	public void setConditions(List<Condition> conditionList) {
		myConditions = conditionList;		
	}
	
	public List<Condition> getConditions() {
		return myConditions;
	}

}
