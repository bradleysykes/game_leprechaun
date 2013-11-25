package data.encoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Condition;
import model.GameMap;
import model.Player;
import model.Resource;
import model.condition.Create;
import model.condition.Defeat;
import model.tile.Tile;
import model.unit.Unit;
import data.Elements;
import data.GameElements;


/**
 * Class that contains the main method for testing the Encoders
 * @author User
 *
 */
public class EncoderMain implements Elements {
    public static void main(String[] args) {
        GameElements currentState = new GameElements();

        //add map to currentState
        GameMap map = new GameMap(3,3);
        Resource minerals = new Resource("minerals", 50, 2);
        Resource gas = new Resource("gas", 50, 2);
        for(Tile tile : map.getAllTiles()) {
            tile.getStatCollection(RESOURCES).addStat(minerals);
            tile.getStatCollection(RESOURCES).addStat(gas);
        }
        currentState.setGameMap(map);
        
        //add playerList to currentState
        List<Player> playerList = new ArrayList<Player>();
        Player p1 = new Player();
        p1.getStatCollection(RESOURCES).addStat(new Resource("minerals", 500, 0));
        p1.getStatCollection(RESOURCES).addStat(new Resource("gas", 350, 0));
        Tile t1 = new Tile(2,1,map);
        Unit unit1 = new Unit("unit1",p1, t1);
        p1.addUnit(unit1);
        
        Player p2 = new Player();
        p2.getStatCollection(RESOURCES).addStat(new Resource("minerals", 820, 0));
        p2.getStatCollection(RESOURCES).addStat(new Resource("gas", 620, 0));
        Tile t2 = new Tile(1,0,map);
        Unit unit2 = new Unit("unit2",p2,t2);
        p1.addUnit(unit2);
        
        playerList.add(p1); playerList.add(p2);
        currentState.setPlayerList(playerList);
        
        //add Conditions to currentState
        List<Condition> conditionList = new ArrayList<Condition>();
        Condition defeatCond = new Defeat("soldier10",p1);
        conditionList.add(defeatCond);
        Condition createCond = new Create("soldier5",p1);
        conditionList.add(createCond);
        currentState.setConditions(conditionList);
        
        //add imageMap to currentState
        HashMap<String, String> unitImageMap = new HashMap<String, String>();
        unitImageMap.put("test1", "src/test1");
        HashMap<String, String> tileImageMap = new HashMap<String, String>();
        tileImageMap.put("test1", "src/test2");
        //populate the imageMaps... then
        currentState.setUnitImageMap(unitImageMap);
        currentState.setTileImageMap(tileImageMap);

        // create a SaveHandler and save an xml file to the specified path
        SaveHandler sh = new SaveHandler(currentState, "./src/data/resources/savedTestFile.xml");
        sh.doSave();

    }
}
