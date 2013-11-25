package data.decoder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import util.reflection.Reflection;
import data.Attributes;
import data.Elements;
import data.GameElements;
import model.Condition;
import model.Player;

/**
 * 
 * DataManager class receives the xml file of defined game elements. 
 * It converts the XML file into the dom document object, pass it to 
 * the decoders. It also collects the objects back from the decoders, 
 * finalizes the deserialization, and sends the game element object to 
 * the game player. 
 * 
 * @author Seunghyun Lee
 *
 */

/*
 * TODO:
 * 1. condition(separate?) - player
 * 2. abilities - unit
 */

public class DataManager extends GameElements implements Attributes, Elements {
    private Element myRoot;
    private List<Decoder> myDecoders;
    public DataManager() {
        super();
        myDecoders = new ArrayList<Decoder>();
        initDecoders();
    }
     
    /**
     * Basic Parsing function. Convert xml file into dom Document
     * so that it can be parsed.
     * @param xml
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void initXmlFile(File xml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xml);
        doc.getDocumentElement().normalize();
        myRoot = doc.getDocumentElement();
    }
    
    /**
     * Initializes the decoder
     */
    private void initDecoders() {
        myDecoders.add(new MapDecoder(this));
        myDecoders.add(new PlayerDecoder(this));
        myDecoders.add(new UnitDecoder(this));
        myDecoders.add(new ImageResourcesDecoder(this));
        myDecoders.add(new ConditionDecoder(this));
    }
    
    /**
     * pass the root element to all decoders so that they can parse and instantiates
     * corresponding objects.
     */
    private void processDecoders() {
        for (Decoder decoder: myDecoders) {
            decoder.decodeData(myRoot);
        }
    }
    
    /**
     * Serialized objects are packed into GameElements object, which is
     * passed to GameLoader from the game player.
     *   
     * @return GameElements
     */
    public GameElements getGameElements(File xmlFile) {
        try {
            initXmlFile(xmlFile);
            processDecoders();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return (GameElements) this;
    }
    
    /**
     * return the player that matches to the input id.
     * @param id
     * @return
     */
    public Player getPlayer(String id) {
        for (Player p : myPlayers) {
            if (p.getID().equals(id)) return p;
        }
        return null;
    }
    
    //test use
    public static void main(String[] args) {
        DataManager dm = new DataManager();
        GameElements map = dm.getGameElements(new File("src/data/resources/TestFile.xml"));
        map.toString();
        System.out.println(map.getTileImageMap().keySet());
        System.out.println(map.getClass());
        Condition hi = (Condition) Reflection.createInstance("model.condition.Create");
        System.out.println(hi.getClass());
    }
}
