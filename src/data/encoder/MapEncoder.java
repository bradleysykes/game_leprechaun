package data.encoder;

import model.GameMap;
import model.Resource;
import model.Resources;
import model.Terrain;
import model.stats.Stat;
import model.tile.Tile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Receives information about a map and converts it to an XML file. It extends
 * the Encoder class.
 * @author Alex Song
 *
 */
public class MapEncoder extends Encoder {
 
    private GameMap myGameMap;
    private Document myXmlDocument;
    private Element myRoot;
    
    
    public MapEncoder(Document xmlDocument, GameMap gameMap, Element root) {
        myGameMap = gameMap;
        myXmlDocument = xmlDocument;
        myRoot = root;
    }
    
    @Override
    public void encode () {
        appendMap(myGameMap);
    }
    
    /**
     * Append the map element and its children elements to the root of the xml file
     * @param gameMap
     */
    private void appendMap (GameMap gameMap) {
        Element mapElement = myXmlDocument.createElement(MAP);
        mapElement.setAttribute(X_DIM, String.valueOf(myGameMap.getSizeX()));
        mapElement.setAttribute(Y_DIM, String.valueOf(myGameMap.getSizeY()));
        for(Tile tile : gameMap.getAllTiles()) {
            appendTile(tile, mapElement);
        }
        myRoot.appendChild(mapElement);
    }
    
    /**
     * Adds a tile element and its children elements to the map element.
     * @param tile tile to add
     */
    private void appendTile(Tile tile, Element mapRoot) {
        Element tileElement = myXmlDocument.createElement(TILE);
        tileElement.setAttribute(X_COORD, String.valueOf(tile.getX()));
        tileElement.setAttribute(Y_COORD, String.valueOf(tile.getY()));
        
        appendStat(tile.getStat(PASSABILITY), tileElement);
        appendStat(tile.getStat(MAX_POP), tileElement);
        
        appendTerrain((Terrain) tile.getStat(TERRAIN), tileElement);
        appendResources((Resources) tile.getStat(RESOURCES), tileElement);
        
        mapRoot.appendChild(tileElement);
    }

    /**
     * Create a statElement for the given stat, and append it to the specified 
     * tileElement 
     * 
     * @param tileElement
     */
    private void appendStat(Stat stat, Element tileElement) {
        Element statElement = myXmlDocument.createElement(STAT);
        statElement.setAttribute(NAME, stat.getName());
        statElement.setAttribute(VALUE, String.valueOf(stat.getValue()));
        tileElement.appendChild(statElement);
    }
    
    /**
     * Create a terrainElement for the given terrain and append it to the 
     * specified tileElement
     * @param terrain
     * @param tileElement
     */
    private void appendTerrain (Terrain terrain, Element tileElement) {
        Element terrainElement = myXmlDocument.createElement(TERRAIN);
        appendStat(terrain.getStat(MAGNITUDE), terrainElement);
        tileElement.appendChild(terrainElement);
    }
    
    /**
     * Create a Resources Element for the given terrain and append it to the 
     * specified tileElement
     * @param resources
     * @param tileElement
     */
    private void appendResources (Resources resources, Element tileElement) {
        Element resourcesElement = myXmlDocument.createElement(RESOURCES);
        for(Stat resource : resources.getStats()) {
            Resource res = (Resource) resource;
            Element resElement = myXmlDocument.createElement(RESOURCE);
            resElement.setAttribute(NAME, res.getName());
            resElement.setAttribute(VALUE, String.valueOf(res.getValue()));
            resourcesElement.appendChild(resElement);
        }
        tileElement.appendChild(resourcesElement);
    }
}
