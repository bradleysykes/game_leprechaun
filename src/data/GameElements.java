package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.GameMap;
import model.Player;
import model.unit.Unit;

// maybe return controller??

public class GameElements {
    private GameMap myGameMap;
    private List<Unit> myUnits;
    private List<Player> myPlayers;
    private Map<String, String> myImages;

    public GameElements(GameMap map, List<Unit> units, List<Player> players) {
        myGameMap = map;
        myUnits = units;
        myPlayers = players;
    }
    
    public GameElements(GameMap map) {
        myGameMap = map;
        myUnits = new ArrayList<Unit>();
        myPlayers = new ArrayList<Player>();
    }
    
    public GameMap getGameMap() {
        return myGameMap;
    }
    
    public List<Unit> getUnits() {
        return myUnits;
    }
    
    public List<Player> getPlayers() {
        return myPlayers;
    }
    
    public void addUnit(Unit unit) {
        myUnits.add(unit);
    }
    
    public void addPlayer(Player player) {
        myPlayers.add(player);
    }
}
