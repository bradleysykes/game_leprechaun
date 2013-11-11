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
    public void addTileElement(Tile tile) {
        Element tileElement = myXmlDocument.createElement(TILE);
        //getX() and getY() needed in tile for x and y positions; hard-coded for now
        tileElement.setAttribute(X_ID, String.valueOf(1));
        tileElement.setAttribute(Y_ID, String.valueOf(1));
        
        Element passabilityElement = myXmlDocument.createElement(PASSABILITY);
        passabilityElement.setTextContent(String.valueOf(tile.getPassability()));
        tileElement.appendChild(passabilityElement);
        
        Element terrainElement = myXmlDocument.createElement(TERRAIN);
        terrainElement.setAttribute(NAME, tile.getTerrain().getName());
        tileElement.appendChild(terrainElement);
        
        Element imageNameElement = myXmlDocument.createElement(TILE_IMAGE);
        imageNameElement.setTextContent(tile.getImageName());
        tileElement.appendChild(imageNameElement);
        
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
    
    /**
     * Removes a tile element and its children from the XML structure
     * @param tile tile to remove
     */
    public void removeTileElement(Tile tile) {
        
    }
    
    /**
     * Edits the specified tile by first removing the tile and creating a new tile
     * based on new specifications
     * @param oldTile the old tile before modifications
     * @param newTile the new tile after modifications
     */
    public void editTileElement(Tile oldTile, Tile newTile) {
        removeTileElement(oldTile);
        addTileElement(newTile);
    }
    
}
