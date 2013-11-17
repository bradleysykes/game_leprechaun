package data.decoder;

import java.util.HashMap;
import java.util.Map;
import data.Attributes;
import data.Elements;
import model.things.Stat;
import model.things.StatCollection;
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
     * This method parses and creates the "stat" object.
     * 
     * @param 
     * @return thing object
     */
    public Stat getThing(Element element) {
        String name = element.getAttribute("name").toString();
        Double value = Double.parseDouble(element.getAttribute("value"));
        Stat stat = (Stat) Reflection.createInstance(name);
        stat.setValue(value);
        return stat;     
    }
    
    public void setStats(Element element, StatCollection things) {
        NodeList thingList = element.getChildNodes();
        for(int i = 0; i < thingList.getLength(); i++) {
            Node thing = thingList.item(i);
            if(thing.getNodeName().equals(THING)) {
                setStat(things, (Element)thing);
            }
        }
    }
    
    public void setStat(StatCollection stats, Element ele) {
        String name = getAttribute(NAME, ele);
        Double value = Double.parseDouble(getAttribute(VALUE, ele));
        stats.setStat(name, value);
    }

    public abstract void load(Element root);
}
