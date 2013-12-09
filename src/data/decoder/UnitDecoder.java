package data.decoder;

import java.util.ArrayList;
import java.util.List;
import model.GameMap;
import model.Player;
import model.abilities.CustomAbility;
import model.effects.ModifyAttribute;
import model.stats.StatCollection;
import model.tile.Tile;
import model.unit.Unit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 * Unit Decoder class is in charge of instantiating all the units 
 * specified in the xml file. Instantiated units will be loaded to
 * Data Manager.
 * 
 * @author Seunghyun Lee
 *
 */
public class UnitDecoder extends Decoder {
    
    private List<Unit> myUnits;
    private static final int DEFAULT = 3;
    
    public UnitDecoder(DataManager manager) {
        super(manager);
        myUnits = new ArrayList<Unit>();
    }
    
    private List<Unit> createUnits(Element root) {
        Element units = (Element)root.getElementsByTagName(UNITS).item(0);
        NodeList unitList = units.getElementsByTagName(UNIT);
        for(int i = 0; i < unitList.getLength(); i++) {
            createUnit((Element)unitList.item(i));
        }
        return myUnits;
    }
    
    /**
     * This method creates a single unit. Besides instantiating a unit,
     * it also deals with the dependency issues. After a unit is created,
     * it will be placed into the corresponding tile and player.
     * @param unit
     * @return
     */
    public Unit createUnit(Element unit) {
        String id = unit.getAttribute(ID);
        
        //get the player that this unit belongs to
        Element player = (Element)unit.getElementsByTagName(UNIT_PLAYER).item(0);
        String playerID = player.getAttribute(ID);
        Player targetPlayer = myDataManager.getPlayer(playerID);
               
        //get the tile that this unit places at
        Element tile = (Element)unit.getElementsByTagName(UNIT_TILE).item(0);
        int x = Integer.parseInt(tile.getAttribute(X_COORD));
        int y = Integer.parseInt(tile.getAttribute(Y_COORD));
        Tile targetTile = myDataManager.getGameMap().getTile(x, y);

        //create unit object
        Unit newUnit = new Unit(id, targetPlayer, targetTile);
        
        //put unit into tile, set tile to unit, add unit to player
        targetTile.addUnit(newUnit);
        targetPlayer.addUnit(newUnit);
               
        //set attributes
        Element attributes = (Element) unit.getElementsByTagName(ATTRIBUTES).item(0);
        StatCollection targetAttributes = (StatCollection) newUnit.getStatCollection(ATTRIBUTES);
        setStats(attributes, targetAttributes);
        
        //set custom abilities if exists
        Element custom = (Element)unit.getElementsByTagName(CUSTOM_ABILITY).item(0);
        try {
            createCustomAbilities(newUnit, custom);             
        }
        catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return newUnit;
    }
    
    /**
     * This method creates "UnitType" object used by game authoring environment. 
     * @param unit
     * @return
     */
    public Unit createUnitType(Element unit) {
        String id = unit.getAttribute(ID);       
        Unit newType = new Unit(id, new Player(), new Tile(DEFAULT,DEFAULT, new GameMap(DEFAULT, DEFAULT)));
        Element attributes = (Element) unit.getElementsByTagName(ATTRIBUTES).item(0);
        StatCollection targetAttributes = (StatCollection) newType.getStatCollection(ATTRIBUTES);
        setStats(attributes, targetAttributes);
        
        return newType;
    }
    
    /**
     * This method create the Custom Abilities created by the game designer.
     * 
     * @param unit
     * @param customAbility
     */

    public void createCustomAbilities(Unit unit, Element customAbility) {
        String name = customAbility.getAttribute(NAME);
        double range = Double.parseDouble(customAbility.getAttribute(RANGE));
        double radius = Double.parseDouble(customAbility.getAttribute(RADIUS));
        CustomAbility custom = new CustomAbility(name, unit, range, radius);
        NodeList effects = customAbility.getElementsByTagName(EFFECT);
        for(int i = 0; i < effects.getLength(); i++) {
            Element effect = (Element) effects.item(i);
            String effectName = effect.getAttribute(NAME);
            String attribute = effect.getAttribute(ATTRIBUTE);
            double power = Double.parseDouble(effect.getAttribute(POWER));
            ModifyAttribute customEffect = new ModifyAttribute(effectName, attribute, power);
            custom.addEffect(customEffect);
        }    
        unit.getStatCollection("Abilities").addStat(custom);
    }
        
    @Override
    public void buildObject (Element root) {
        createUnits(root);
    }
}
