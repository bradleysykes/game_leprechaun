package data.encoder;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
        printToConsole();
    }
    
    /**
     * Append the map element and its children elements to the root of the xml file
     * @param gameMap
     */
    private void appendMap (GameMap gameMap) {
        Element mapElement = myXmlDocument.createElement(MAP_ROOT);
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
        
        appendStat(tileElement, tile.getStat(PASSABILITY));
        appendStat(tileElement, tile.getStat(MAX_POP));
        
        appendTerrain(tileElement, (Terrain) tile.getStat(TERRAIN));
        appendResources(tileElement, (Resources) tile.getStat(RESOURCES));
        
        mapRoot.appendChild(tileElement);
    }

    /**
     * Create a statElement for the given stat, and append it to the specified 
     * tileElement 
     * 
     * @param tileElement
     */
    private void appendStat(Element tileElement, Stat stat) {
        Element statElement = myXmlDocument.createElement(STAT);
        statElement.setAttribute(NAME, stat.getName());
        statElement.setAttribute(VALUE, String.valueOf(stat.getValue()));
        tileElement.appendChild(statElement);
    }
    
    /**
     * Create a terrainElement for the given terrain and append it to the 
     * specified tileElement
     * @param tileElement
     * @param terrain
     */
    private void appendTerrain (Element tileElement, Terrain terrain) {
        Element terrainElement = myXmlDocument.createElement(TERRAIN);
        appendStat(terrainElement, terrain.getStat(MAGNITUDE));
        tileElement.appendChild(terrainElement);
    }
    
    /**
     * Create a Resources Element for the given terrain and append it to the 
     * specified tileElemen
     * @param tileElement
     * @param resources
     */
    private void appendResources (Element tileElement, Resources resources) {
        Element resourcesElement = myXmlDocument.createElement(RESOURCE);
        for(Stat resource : resources.getStats()) {
            Resource res = (Resource) resource;
            Element resElement = myXmlDocument.createElement(RESOURCE);
            resElement.setAttribute(NAME, res.getName());
            resElement.setAttribute(VALUE, String.valueOf(res.getValue()));
            resourcesElement.appendChild(resElement);
        }
        tileElement.appendChild(resourcesElement);
    }


    //for testing
    private void printToConsole() {
      //FileOutputStream fos = new FileOutputStream(new File("test.xml"));
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = formatXML(tFactory.newTransformer());
        }
        catch (TransformerConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //use fos for saving to file; use System.out for printing to console
        try {
            transformer.transform(new DOMSource(myXmlDocument), new StreamResult(System.out));
        }
        catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
