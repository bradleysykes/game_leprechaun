package data.decoder;

import java.util.HashMap;
import java.util.Map;
import data.Attributes;
import data.Elements;
import model.things.Thing;
import model.things.ThingsThing;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
    
    /**
     * This method creates the "thing" object.
     * 
     * @param thingElement
     * @return thing object
     */
    public Thing getThing(Element thingElement) {
        String field = thingElement.getAttribute("field").toString();
        String name = thingElement.getAttribute("name").toString();
        String value = thingElement.getAttribute("value");
        Thing thing = (Thing) Reflection.createInstance(myThingsClassPaths.get(field), name);
        thing.setValue(value);
        return thing;     
    }
    
    public void setThings(Element element, ThingsThing things) {
        NodeList thingList = element.getChildNodes();
        for(int i = 0; i < thingList.getLength(); i++) {
            Node thing = thingList.item(i);
            if(thing.getNodeName().equals(THING)) {
                setThing(things, (Element)thing);
            }
        }

    }
    
    public void setThing(ThingsThing thing, Element ele) {
        String name = getAttribute(NAME, ele);
        String value = getAttribute(VALUE, ele);
        thing.setValue(name, value);
    }

    public abstract void load(Element root);
}
