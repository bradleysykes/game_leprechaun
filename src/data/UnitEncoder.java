package data;

import javax.xml.parsers.ParserConfigurationException;


/**
 * Receives information about units and converts it to an XML file. It extends
 * the Encoder class.
 * @author Alex Song
 *
 */
public class UnitEncoder extends Encoder{

    /**
     * Creates a new instance of a UnitEncoder which converts Unit information
     * into an XML file. 
     * @throws ParserConfigurationException
     */
    public UnitEncoder() throws ParserConfigurationException {
        initEncoder(UNIT_ROOT_NAME);
    }
    
    
    public void addXmlElement(Object o) {
       
    }
    
    public void removeXmlElement(Object o) {
       
    }
    
    public void editXmlElement(Object o1, Object o2) {
       
    }
}
