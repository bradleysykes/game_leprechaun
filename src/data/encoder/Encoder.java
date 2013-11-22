package data.encoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;
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
import model.tile.Tile;
import model.unit.Unit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import data.Attributes;
import data.Elements;


/**
 * Receives information about a certain type of object and creates an XML file
 * that represents it. It is a superclass that is extended by different encoder
 * subclasses. It implements interfaces which hold constants representing the
 * names of XML elements and attributes.
 * @author Alex Song
 *
 */
public abstract class Encoder implements Elements, Attributes {
    
    
    
    /**
     * Saves the XML to a separate file specified by fileName
     * @param fileName name of the xml file
     * @throws TransformerException
     * @throws FileNotFoundException
     */
    public void saveXML(String fileName) throws TransformerException, FileNotFoundException {
//        FileOutputStream fos = new FileOutputStream(new File(fileName));
//        TransformerFactory tFactory = TransformerFactory.newInstance();
//        Transformer transformer = formatXML(tFactory.newTransformer());
//        // use fos for saving to file; use System.out for printing to console
//        transformer.transform(new DOMSource(myXmlDocument), new StreamResult(fos));
    }

    /**
     * start encoding
     */
    public abstract void encode();
    

}
