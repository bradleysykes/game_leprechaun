package data.decoder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import data.Attributes;
import data.Elements;
import engine.GameEngine;
import model.things.Thing;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import util.reflection.Reflection;


/**
 * Abstract Decoder class.
 * 
 * This class will be the superclass of specific decoders.
 * Decoder will parse the xml file, get the corresponding data,
 * and create the objects.
 * 
 * @author Seunghyun Lee
 *
 */
public abstract class Decoder implements Attributes, Elements {
    public static final String INT_THING = "Integer";
    public static final String DOUBLE_THING = "Double";
    public static final String STRING_THING = "String";
    
    public Map<String, String> myThingsClassPaths;
    public Decoder() {
        myThingsClassPaths = new HashMap<String,String>();
        initThingsMap();
    }
    
    public void initThingsMap() {
        myThingsClassPaths.put(INT_THING, "model.things.IntegerThing");
        myThingsClassPaths.put(DOUBLE_THING, "model.things.DoubleThing");
        myThingsClassPaths.put(STRING_THING, "model.things.StringThing");
    }
    public String getAttribute(String tag, Element element) {
        return element.getAttribute(tag).toString();
    }
    
    //use reflection
    public Thing processThing(Element thingElement) {
        String field = thingElement.getAttribute("field");
        String name = thingElement.getAttribute("name");
        if(field.equals(INT_THING)) {
//            
        }
        Object value = thingElement.getAttribute("value");
        return (Thing) Reflection.createInstance(myThingsClassPaths.get(field), name, value);
    }
    
    public abstract void load(Element root);
}
