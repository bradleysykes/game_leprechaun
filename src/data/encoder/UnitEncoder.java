package data.encoder;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import model.Abilities;
import model.Attributes;
import model.Effect;
import model.Effects;
import model.Player;
import model.Resources;
import model.abilities.CustomAbility;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class UnitEncoder extends Encoder {

    List<Player> myPlayerList;
    private Document myXmlDocument;
    Element myRoot;
    
    public UnitEncoder(Document xmlDocument, List<Player> playerList, Element root) {
        myXmlDocument = xmlDocument;
        myPlayerList = playerList;
        myRoot = root;
    }
    
    @Override
    public void encode () {
        List<Unit> unitList = new ArrayList<Unit>();
        for(Player player : myPlayerList) {
            unitList.addAll(player.getAllUnits());
        }
        appendUnits(unitList);
    }

    private void appendUnits (List<Unit> unitList) {
        Element unitsElement = myXmlDocument.createElement(UNITS);
        for(Unit unit : unitList) {
            appendSingleUnit(unit, unitsElement,false);
        }
        myRoot.appendChild(unitsElement);
    }

    protected void appendSingleUnit (Unit unit, Element unitsElement, boolean isType) {
        Element unitElement = null;
        if(isType) {
            unitElement = myXmlDocument.createElement(UNIT_TYPE);
        } else {
            unitElement = myXmlDocument.createElement(UNIT);
        }
        unitElement.setAttribute(ID, unit.getID());
        unitsElement.appendChild(unitElement);
        
        Element playerElement = myXmlDocument.createElement(UNIT_PLAYER);
        playerElement.setAttribute(ID, unit.getPlayer().getID());
        unitElement.appendChild(playerElement);
        
        Element tileElement = myXmlDocument.createElement(UNIT_TILE);
        tileElement.setAttribute(X_COORD, String.valueOf(unit.getCurrentTile().getX()));
        tileElement.setAttribute(Y_COORD, String.valueOf(unit.getCurrentTile().getY()));
        unitElement.appendChild(tileElement);
        
        Element abilitiesElement = myXmlDocument.createElement(ABILITIES);
        Abilities abilities = (Abilities) unit.getStatCollection(ABILITIES);
        appendSpawnAbility(abilities.getStatCollection("Spawn"), abilitiesElement);
        appendCustomAbilities(abilities, abilitiesElement);
        unitElement.appendChild(abilitiesElement);
        
        Attributes attributes = (Attributes) unit.getStatCollection(ATTRIBUTES);
        appendAttributes(attributes, unitElement);
        
        PlayerEncoder pe = new PlayerEncoder(myXmlDocument, null, null);
        pe.appendResources((Resources) unit.getStatCollection(RESOURCES), unitElement);
    }
    
    private void appendSpawnAbility (StatCollection spawnStat, Element abilitiesElement) {
        Element abilityElement = myXmlDocument.createElement(ABILITY);
        for(String reference : spawnStat.getReferences()) {
            Element referenceElement = myXmlDocument.createElement(REFERENCE);
            referenceElement.setAttribute(NAME, reference);
            abilityElement.appendChild(referenceElement);
        }
        abilitiesElement.appendChild(abilityElement);
    }

    private void appendCustomAbilities (Abilities abilities, Element abilitiesElement) {
        Element customAbElement = myXmlDocument.createElement(CUSTOM_ABILITY);
        for (Stat s : abilities.getStats()) {
            if(s instanceof CustomAbility) {
                String name = s.getName();
                CustomAbility c = (CustomAbility) s;
                customAbElement.setAttribute(NAME, name);
                customAbElement.setAttribute(RANGE, String.valueOf(c.getStat("Range").getValue()));
                customAbElement.setAttribute(RADIUS, String.valueOf(c.getStat("Radius").getValue()));
                for(Effect effect : ((Effects) c.getStat("Effects")).getEffects()){
                    Element effectElement = myXmlDocument.createElement("Effect");
                    effectElement.setAttribute(NAME, effect.getName());
                    effectElement.setAttribute(ATTRIBUTE, effect.getID());
                    effectElement.setAttribute(POWER, String.valueOf(effect.getStat("Power").getValue()));
                    customAbElement.appendChild(effectElement);
                }
            }
        }
        abilitiesElement.appendChild(customAbElement);
    }

    private void appendAttributes (Attributes attributes, Element unitElement) {
        Element attributesElement = myXmlDocument.createElement(ATTRIBUTES);
        for(Stat attr : attributes.getStats()) {
            Element statElement = myXmlDocument.createElement(STAT);
            statElement.setAttribute(NAME, attr.getName());
            statElement.setAttribute(VALUE, String.valueOf(attr.getValue()));
            attributesElement.appendChild(statElement);
        }
        unitElement.appendChild(attributesElement);
    }

}
