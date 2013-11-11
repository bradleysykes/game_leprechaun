package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Resource;
import model.Resources;
import model.Terrain;
import model.Tile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Receives information about a certain type of object and creates an XML file
 * that represents it. It is a superclass that is extended by different subclasses.
 * It implements interfaces which hold constants representing the names of XML 
 * elements and attributes.
 * @author Alex Song
 *
 */
public abstract class Encoder implements Elements, Attributes {
    
    protected Document myXmlDocument;
    protected Element myRoot;
    
    /**
     * Initializes the file by creating a document and appending a root element
     * with rootName.
     * @param rootName name of the root element
     * @throws ParserConfigurationException
     */
    protected void initEncoder(String rootName)
            throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        myXmlDocument = builder.newDocument();
        myRoot = myXmlDocument.createElement(rootName);
        myXmlDocument.appendChild(myRoot);
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
     * Saves the XML to a separate file specified by fileName
     * @param fileName name of the xml file
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

    /**
     * Add the specified element to the XML file
     * @param o
     */
    public abstract void addXmlElement(Object o);
    
    /**
     * Remove the specified element from the XML file 
     * @param o
     */
    public abstract void removeXmlElement(Object o);
    
    /**
     * Edit the specified element in the XML file
     * @param o
     */
    public abstract void editXmlElement(Object o1, Object o2);
    
    
    //for testing
    public static void main(String[] args) throws Exception {
        Encoder e = new MapEncoder();
        //add Tile
        Resources resources = new Resources();
        resources.addResource(new Resource("minerals", 10, 5));
        resources.addResource(new Resource("gas", 20, 7));
        Terrain terrain = new Terrain();
        terrain.setName("grass");
        // tile should have x and y position
        Tile tile = new Tile(resources, 1, terrain, "src/gae_resources/grass.jpg");
        e.addXmlElement(tile);
        
        //add another tile
        resources = new Resources();
        resources.addResource(new Resource("minerals", 36, 7));
        resources.addResource(new Resource("gas", 46, 25));
        terrain = new Terrain();
        terrain.setName("sand");
        // tile should have x and y position
        tile = new Tile(resources, 0, terrain, "src/gae_resources/sand.jpg");
        e.addXmlElement(tile);
        
        e.saveXML("src/dataResources/map.xml");
    }
    

}
