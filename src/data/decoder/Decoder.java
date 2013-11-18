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
    
    /**
     * return the attribute of element to the corresponding tag.  
     */
    public String getAttribute(String tag, Element element) {
        return element.getAttribute(tag).toString();
    }
    
    /**
     * This method parses and creates the "Stat" object.
     * 
     * @param element the node of 
     * @return Stat stat object
     */
    public Stat getStat(Element element) {
        String name = element.getAttribute("name").toString();
        Double value = Double.parseDouble(element.getAttribute("value"));
        Stat stat = (Stat) Reflection.createInstance(name);
        stat.setValue(value);
        return stat;     
    }
    
    /**
     * 
     * @param element
     * @param things
     */
    public void setStats(Element element, StatCollection things) {
        NodeList thingList = element.getChildNodes();
        for(int i = 0; i < thingList.getLength(); i++) {
            Node thing = thingList.item(i);
            if(thing.getNodeName().equals(THING)) {
                setStat(things, (Element)thing);
            }
        }
    }
    
    /**
     * 
     * @param stats
     * @param ele
     */
    public void setStat(StatCollection stats, Element element) {
        String name = getAttribute(NAME, element);
        Double value = Double.parseDouble(getAttribute(VALUE, element));
        stats.setStat(name, value);
    }

    /**
     * this method will parse the data and set corresponding 
     * @param root
     */
    public abstract void decodeData(Element root);
}
