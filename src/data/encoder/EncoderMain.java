package data.encoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Abilities;
import model.Attributes;
import model.Condition;
import model.GameMap;
import model.Player;
import model.Resource;
import model.abilities.CustomAbility;
import model.condition.Create;
import model.condition.Defeat;
import model.effects.ModifyAttribute;
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
            tile.setID("idyaysdf");
        }
        currentState.setGameMap(map);
        
        //add playerList to currentState
        List<Player> playerList = new ArrayList<Player>();
        Player p1 = new Player();
        p1.getStatCollection(RESOURCES).addStat(new Resource("minerals", 500, 0));
        p1.getStatCollection(RESOURCES).addStat(new Resource("gas", 350, 0));
        Tile t1 = new Tile(2,1,map);
        
        Unit unit1 = new Unit("unit1",p1, t1);
        CustomAbility customAb = new CustomAbility("testCustom", new Unit("testUser",p1,t1), 30.0, 12.4);
        customAb.addEffect(new ModifyAttribute("testEffect","testAttr",1000.20));
        customAb.addEffect(new ModifyAttribute("test2","anotherAttr?",23.10));
        
        Attributes a = (Attributes) unit1.getStatCollection("Attributes");
        a.setStat("Health", 20.0);
        a.setStat("Base Attack", 36.2);
        unit1.getStatCollection("Abilities").addStat(customAb);
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
        HashMap<Unit, String> unitImageMap = new HashMap<Unit, String>();
        unitImageMap.put(new Unit("unit1", p1, t2), "src/test1");
        HashMap<Tile, String> tileImageMap = new HashMap<Tile, String>();
        Tile tile = new Tile(0,0,map);
        tile.setID("tileIdddd");
        tileImageMap.put(tile, "src/test2");
        //populate the imageMaps... then
        currentState.setUnitImageMap(unitImageMap);
        currentState.setTileImageMap(tileImageMap);

        // create a SaveHandler and save an xml file to the specified path
        SaveHandler sh = new SaveHandler(currentState, "./src/data/resources/savedTestFile.xml");
        sh.doSave();

    }
}
