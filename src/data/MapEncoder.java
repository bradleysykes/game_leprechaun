package data;

import javax.xml.parsers.ParserConfigurationException;
import model.Resource;
import model.Tile;
import org.w3c.dom.Element;


/**
 * Receives information about a map and converts it to an XML file. It extends
 * the Encoder class.
 * @author Alex Song
 *
 */
public class MapEncoder extends Encoder {
 
    /**
     * Creates a new instance of a MapEncoder which converts map information into
     * an XML file. 
     * @throws ParserConfigurationException
     */
    public MapEncoder() throws ParserConfigurationException {
        initEncoder(MAP_ROOT_NAME);
    }

    /**
     * Adds a tile element and its children elements to the root element.
     * @param tile tile to add
     */
    private void addTileElement(Tile tile) {
        Element tileElement = myXmlDocument.createElement(TILE);
        //getX() and getY() needed in tile for x and y positions; hard-coded for now
        tileElement.setAttribute(X_ID, String.valueOf(1));
        tileElement.setAttribute(Y_ID, String.valueOf(1));
        tileElement.setAttribute(PASSABILITY, String.valueOf(tile.getPassability()));
        tileElement.setAttribute(IMAGE, tile.getImageName());
        
        Element terrainElement = myXmlDocument.createElement(TERRAIN);
        terrainElement.setAttribute(NAME, tile.getTerrain().getName());
        tileElement.appendChild(terrainElement);
        
        // tile can have multiple resources
        Element resourcesElement = myXmlDocument.createElement(RESOURCES);        
        for(Resource resource : tile.getResourcesOnTile()) {
            Element resourceElement = myXmlDocument.createElement(RESOURCE);
            resourceElement.setAttribute(NAME, resource.getName());
            resourceElement.setAttribute(AMOUNT, String.valueOf(resource.getAmount()));
            resourceElement.setAttribute(HARVEST_RATE, String.valueOf(resource.getHarvestRate()));
            resourcesElement.appendChild(resourceElement);
        }
        tileElement.appendChild(resourcesElement);
        
        myRoot.appendChild(tileElement);
    }

    public void addXmlElement(Object o) {
        addTileElement((Tile) o);
    }
    
    /**
     * Removes a tile element and its children from the XML structure
     * @param tile tile to remove
     */
    private void removeTileElement(Tile tile) {
        //TODO
    }
    
    public void removeXmlElement(Object o) {
        removeTileElement((Tile) o);
    }
    
    /**
     * Edits the specified tile by first removing the tile and creating a new tile
     * based on new specifications
     * @param oldTile the old tile before modifications
     * @param newTile the new tile after modifications
     */
    private void editTileElement(Tile oldTile, Tile newTile) {
        removeTileElement(oldTile);
        addTileElement(newTile);
    }
    
    public void editXmlElement(Object o1, Object o2) {
        editTileElement((Tile) o1, (Tile) o2);
    }
}
