package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.*;
import model.Resource;
import model.Resources;
import model.Terrain;
import model.Tile;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;


public class MapEncoder {
    
    private Document myXmlDocument;
    private Element myRoot;
    
    /**
     * Creates a new instance of a MapEncoder which converts data for creating 
     * a map into an XML file. 
     * @throws ParserConfigurationException
     */
    public MapEncoder() throws ParserConfigurationException {
        initEncoder();
    }
    
    /**
     * Initializes the file by creating a document and appending a root element
     * called "map".
     * @throws ParserConfigurationException
     */
    private void initEncoder() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        myXmlDocument = builder.newDocument();
        myRoot = myXmlDocument.createElement("map");
        myXmlDocument.appendChild(myRoot);
    }
    
    /**
     * Adds a tile element and its children elements to the root element.
     * @param tile tile to add
     */
    public void addTile(Tile tile) {
        Element tileElement = myXmlDocument.createElement("tile");
        //getX() and getY() needed in tile for x and y positions; hard-coded for now
        tileElement.setAttribute("xid", String.valueOf(1));
        tileElement.setAttribute("yid", String.valueOf(1));
        
        Element passabilityElement = myXmlDocument.createElement("passability");
        passabilityElement.setTextContent(String.valueOf(tile.getPassability()));
        tileElement.appendChild(passabilityElement);
        
        Element terrainElement = myXmlDocument.createElement("terrain");
        terrainElement.setAttribute("name", tile.getTerrain().getName());
        tileElement.appendChild(terrainElement);
        
        Element imageNameElement = myXmlDocument.createElement("image_name");
        imageNameElement.setTextContent(tile.getImageName());
        tileElement.appendChild(imageNameElement);
        
        // tile can have multiple resources
        Element resourcesElement = myXmlDocument.createElement("resources");        
        for(Resource resource : tile.getResourcesOnTile()) {
            Element resourceElement = myXmlDocument.createElement("resource");
            resourceElement.setAttribute("name", resource.getName());
            resourceElement.setAttribute("amount", String.valueOf(resource.getAmount()));
            resourceElement.setAttribute("harvest_rate", String.valueOf(resource.getHarvestRate()));
            resourcesElement.appendChild(resourceElement);
        }
        tileElement.appendChild(resourcesElement);
        
        myRoot.appendChild(tileElement);
    }
    
    /**
     * Removes a tile element and its children from the XML structure
     * @param tile tile to remove
     */
    public void removeTile(Tile tile) {
        
    }
    
    /**
     * Edits the specified tile by first removing the tile and creating a new tile
     * based on new specifications
     * @param oldTile the old tile before modifications
     * @param newTile the new tile after modifications
     */
    public void editTile(Tile oldTile, Tile newTile) {
        removeTile(oldTile);
        addTile(newTile);
    }
    
    /**
     * Formats the XML file to omit XML Declaration and create indentations 
     * @param transformer
     * @return
     */
    private Transformer formatXML(Transformer transformer) {
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        return transformer;
    }
    
    /**
     * Saves the XML to a separate file
     * @throws TransformerException
     * @throws FileNotFoundException
     */
    public void saveXML(String fileName) throws TransformerException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(new File(fileName));
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = formatXML(tFactory.newTransformer());
        // use fos for saving to file; use System.out for printing to console
        transformer.transform(new DOMSource(myXmlDocument), new StreamResult(fos));
    }
    
    //for testing
    public static void main(String[] args) throws Exception {
        MapEncoder e = new MapEncoder();
        //add Tile
        Resources resources = new Resources();
        resources.addResource(new Resource("minerals", 10, 5));
        resources.addResource(new Resource("gas", 20, 7));
        Terrain terrain = new Terrain();
        terrain.setName("grass");
        // tile should have x and y position
        Tile tile = new Tile(resources, 1, terrain, "gae_resources/grass.jpg");
        e.addTile(tile);
        
        //add another tile
        resources = new Resources();
        resources.addResource(new Resource("minerals", 36, 7));
        resources.addResource(new Resource("gas", 46, 25));
        terrain = new Terrain();
        terrain.setName("sand");
        // tile should have x and y position
        tile = new Tile(resources, 0, terrain, "gae_resources/sand.jpg");
        e.addTile(tile);
        
        e.saveXML("src/dataResources/map.xml");
    }
}
