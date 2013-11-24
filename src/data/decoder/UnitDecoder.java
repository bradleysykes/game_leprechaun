package data.decoder;

import java.util.ArrayList;
import java.util.List;
import model.Player;
import model.stats.StatCollection;
import model.tile.Tile;
import model.unit.Unit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 * Decoder for unit objects
 * @author Seunghyun Lee
 *
 */
public class UnitDecoder extends Decoder {
    
    private DataManager myDataManager;
    private List<Unit> myUnits;
    
    public UnitDecoder(DataManager manager) {
        myDataManager = manager;
        myUnits = new ArrayList<Unit>();
    }
    
    private List<Unit> processUnits(Element root) {
        Element units = (Element)root.getElementsByTagName(UNITS).item(0);
        NodeList unitList = units.getElementsByTagName(UNIT);
        for(int i = 0; i < unitList.getLength(); i++) {
            createSingleUnit((Element)unitList.item(i));
        }
        
        return myUnits;
    }
    
    private Unit createSingleUnit(Element unit) {
        String id = unit.getAttribute(ID);
        
        //get the player that this unit belongs to
        Element player = (Element)unit.getElementsByTagName(UNIT_PLAYER).item(0);
        String playerID = player.getAttribute(ID);
        Player targetPlayer = myDataManager.getPlayer(playerID);
        
        //create unit object
        Unit newUnit = new Unit(id, targetPlayer, myDataManager.getGameMap());
               
        //get the tile that this unit places at
        Element tile = (Element)unit.getElementsByTagName(UNIT_TILE).item(0);
        int x = Integer.parseInt(tile.getAttribute(X_COORD));
        int y = Integer.parseInt(tile.getAttribute(Y_COORD));
        Tile targetTile = myDataManager.getGameMap().getTile(x, y);
        
        //put unit into tile, set tile to unit, add unit to player
        targetTile.addUnit(newUnit);
        newUnit.setCurrentTile(targetTile);
        targetPlayer.addUnit(newUnit);
        
        //set abilities
        
        //set attributes
        Element attributes = (Element) unit.getElementsByTagName(ATTRIBUTES).item(0);
        StatCollection targetAttributes = (StatCollection) newUnit.getStatCollection(ATTRIBUTES);
        setStats(attributes, targetAttributes);

        return newUnit;
    }
      
    @Override
    public void decodeData (Element root) {
        //myDataManager.setUnits(processUnits(root));
        processUnits(root);
    }
}
