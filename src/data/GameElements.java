package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Condition;
import model.GameMap;
import model.Player;
import model.unit.Unit;


public class GameElements {

    protected GameMap myGameMap;
    protected List<Player> myPlayers;
    protected List<Unit> myUnitTypes;
    protected Map<String, String> myTileImages;
    protected Map<String, String> myUnitImages;
    protected List<Condition> myVictoryConditions;

    public GameElements(GameMap map, List<Player> players, Map<String, String> tileImages, 
                        Map<String, String> unitImages) {
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
    
    public void setTileImageMap(Map<String, String> imageMap) {
    	myTileImages = imageMap;
    }
    
    public Map<String, String> getImageMap() {
        return myTileImages;
    }
    
    public void setUnitImageMap(Map<String, String> imageMap) {
        myUnitImages = imageMap;
    }
    
    public void setUnitTypes(List<Unit> unitTypes) {
    	myUnitTypes = unitTypes;
    }
    
    public List<Unit> getUnitTypes() {
    	return myUnitTypes;
    }

	public void setConditions(List<Condition> conditionList) {
		myVictoryConditions = conditionList;		
	}
	
	public List<Condition> getConditions() {
		return myVictoryConditions;
	}

}
