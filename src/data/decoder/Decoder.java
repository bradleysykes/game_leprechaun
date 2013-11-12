package data.decoder;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import data.constants.Attributes;
import data.constants.Elements;
import engine.GameEngine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Abstract Decoder class.
 * 
 * This class will be the superclass of specific decoders.
 * Decoder will parse the xml file, get the corresponding data,
 * and create the objects. (Parser + Factory)
 * 
 * @author Seunghyun Lee
 *
 */
public abstract class Decoder implements Attributes, Elements {
    Element myRoot;
    
    public Decoder(Element root) {
        myRoot = root;
    }
        
    public String getAttribute(String tag, Element element) {
        return element.getAttribute(tag).toString();
    }
    
    public abstract void load(GameEngine engine);
    
    
}
