package data.encoder;

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
     * Perform the encode-to-XML process
     */
    protected abstract void encode();
    

}
