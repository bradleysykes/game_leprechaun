package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.*;
import model.Resource;
import model.Resources;
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
     *  
     * @throws ParserConfigurationException
     */
    public MapEncoder() throws ParserConfigurationException {
        initEncoder();
    }
    
    /**
     * Initializes the file by creating a document and appending a root element
     * called "map".
     * 
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
     * 
     * @param x x-position of the tile
     * @param y y-position of the tile
     * @param pass passability value
     * @param terrName name of terrain
     * @param rList list of resources
     */
    public void addTile(int x, int y, double pass, String terrName, Resources rList) {
        Element tileElement = myXmlDocument.createElement("tile");
        tileElement.setAttribute("xid", String.valueOf(x));
        tileElement.setAttribute("yid", String.valueOf(y));
        
        Element passabilityElement = myXmlDocument.createElement("passability");
        passabilityElement.setTextContent(String.valueOf(pass));
        tileElement.appendChild(passabilityElement);
        
        Element terrainElement = myXmlDocument.createElement("terrain");
        terrainElement.setAttribute("name", terrName);
        tileElement.appendChild(terrainElement);
        
        Element resourcesElement = myXmlDocument.createElement("resources");        
        for(Resource resource : rList.getResources()) {
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
     * Formats the XML file to omit XML Declaration and create indentations 
     * 
     * @param transformer
     * @return
     */
    private Transformer formatXML(Transformer transformer) {
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        return transformer;
    }
    
    public void saveXML() throws TransformerException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(new File("map.xml"));
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
        e.addTile(1, 2, 1, "grass", resources);
        //add another tile
        resources = new Resources();
        resources.addResource(new Resource("minerals", 36, 7));
        resources.addResource(new Resource("gas", 46, 25));
        e.addTile(2, 2, 0, "sand", resources);
        
        e.saveXML();
    }
}
