package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.GameMap;
import model.Player;
import model.unit.Unit;


public class GameElements {
    private GameMap myGameMap;
    private List<Player> myPlayers;
    private Map<String, String> myImages;

    public GameElements(GameMap map, List<Unit> units, List<Player> players) {
        myGameMap = map;
        myPlayers = players;
    }
    
    public GameElements(GameMap map) {
        myGameMap = map;
        myPlayers = new ArrayList<Player>();
    }
    
    public GameMap getGameMap() {
        return myGameMap;
    }
       
    public List<Player> getPlayers() {
        return myPlayers;
    }
    
    public void addPlayer(Player player) {
        myPlayers.add(player);
    }
    
    public Map<String, String> getImageMap() {
        return myImages;
    }
}