package data.encoder;

import javax.xml.parsers.ParserConfigurationException;
import model.GameMap;
import model.Resource;
import model.tile.Tile;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Receives information about a map and converts it to an XML file. It extends
 * the Encoder class.
 * @author Alex Song
 *
 */
public class MapEncoder extends Encoder {
 
    private GameMap gameMap;
    /**
     * Creates a new instance of a MapEncoder which converts map information into
     * an XML file. 
     * @param xDim x-dimension of the game map
     * @param yDim y-dimension of the game map
     * @throws ParserConfigurationException
     */
    public MapEncoder(int xDim, int yDim) throws ParserConfigurationException {
        //gameMap = new GameMap(xDim, yDim);
        initEncoder(MAP_ROOT_NAME);
        myRoot.setAttribute(X_DIM, String.valueOf(xDim));
        myRoot.setAttribute(Y_DIM, String.valueOf(yDim));
    }

    /**
     * Adds a tile element and its children elements to the root element.
     * @param tile tile to add
     */
    private void addTileElement(Tile tile) {
        Element tileElement = myXmlDocument.createElement(TILE);
        tileElement.setAttribute(X_COORD, String.valueOf(tile.getX()));
        tileElement.setAttribute(Y_COORD, String.valueOf(tile.getY()));
        tileElement.setAttribute(PASSABILITY, String.valueOf(tile.getPassability()));
        tileElement.setAttribute(IMAGE, tile.getImageName());
        tileElement.setAttribute(MAX_POP, String.valueOf(tile.getMaxPop()));
        
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
        Element current = myRoot;
        NodeList children = current.getChildNodes();
        for(int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            NamedNodeMap attributes = child.getAttributes();
            String xCoord = attributes.getNamedItem(X_COORD).toString();
            String yCoord = attributes.getNamedItem(Y_COORD).toString();
            if(xCoord.equals(X_COORD + "=\"" + tile.getX() + "\"") &&
                    yCoord.equals(Y_COORD + "=\"" + tile.getY() + "\"")) {
                current.removeChild(child);
                i--;
            }
        }
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
