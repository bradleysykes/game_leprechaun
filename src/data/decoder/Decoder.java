package data.decoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import data.Attributes;
import data.Elements;
import model.Resource;
import model.Resources;
import model.stats.Stat;
import model.stats.StatCollection;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.reflection.Reflection;


/**
 * Abstract Decoder class.
 * 
 * Abstract Decoder class receives the ¡®dom¡¯ document object from 
 * the data manager, instantiates the right elements and load them 
 * back to the Data Manager. 
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
     * This method parses and instantiates the "Stat" object.
     * 
     * @param element the node of 
     * @return Stat stat object
     */
    public Stat getStat(Element element) {
        String name = element.getAttribute(NAME).toString();
        Double value = Double.parseDouble(element.getAttribute(VALUE));
        Stat stat = (Stat) Reflection.createInstance(name);
        stat.setValue(value);
        return stat;     
    }
    
    /**
     * This method instantiates and set corresponding Stat objects to
     * StatCollection object.
     * 
     * @param element
     * @param stats
     */
    public void setStats(Element element, StatCollection stats) {
        NodeList statList = element.getChildNodes();
        for(int i = 0; i < statList.getLength(); i++) {
            Node stat = statList.item(i);
            if(stat.getNodeName().equals(STAT)) {
                setStat((Element)stat, stats);
            }
        }
    }
    
    /**
     * This method instantiates a single Stat object and set it to the
     * given StatCollection object.
     * 
     * @param element
     * @param stats
     */
    public void setStat(Element element, StatCollection stats) {
        String name = getAttribute(NAME, element);
        Double value = Double.parseDouble(getAttribute(VALUE, element));
        stats.setStat(name, value);
    }
 
    /**
     * This method parses and instantiates Resources objects. It is used both in
     * PlayerDecoder and MapDecoder.
     * 
     * @param resources
     * @param target
     * @return
     */
    public Resources processResources(Element resources, Resources target) {
        NodeList resourceList = resources.getElementsByTagName(RESOURCE);
        for(int i = 0; i < resourceList.getLength(); i++) {
            Element resource = (Element) resourceList.item(i);
            String name = resource.getAttribute(NAME);
            Double amount = Double.parseDouble(resource.getAttribute(AMOUNT));
            Double harvestRate = Double.parseDouble(resource.getAttribute(HARVEST_RATE));
            target.addResource(new Resource(name, amount, harvestRate));
       }
       return target;
    }
    
    public List<Element> getChildrenByTagName(Element parent, String name) {
        List<Element> nodeList = new ArrayList<Element>();
        for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
          if (child.getNodeType() == Node.ELEMENT_NODE && 
              name.equals(child.getNodeName())) {
            nodeList.add((Element) child);
          }
        }

        return nodeList;
      }

    
    /**
     * this method will parse the data and set corresponding 
     * @param root
     */
    public abstract void decodeData(Element root);
}
