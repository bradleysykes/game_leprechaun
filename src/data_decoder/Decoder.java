package data_decoder;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import data_constants.Attributes;
import data_constants.Elements;
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
 * and create the object. (Parser + Factory)
 * 
 * @author Seunghyun Lee
 *
 */
public abstract class Decoder implements Attributes, Elements {
    GameEngine myEngine;
    
    
    public Decoder(GameEngine engine, File xml) {
        myEngine = engine;
    }
    
    public String getElement(String tag, Element element) {
        return element.getElementsByTagName(tag).toString();
    }
    
    public abstract void create(Element element);
    
    
}