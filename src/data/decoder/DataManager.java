package data.decoder;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import util.xmlserializer.ObjectWriteException;
import util.xmlserializer.XMLSerializerUtil;
import model.Attributes;
import model.GameMap;
import model.Player;
import model.unit.Unit;
import engine.GameEngine;
import util.reflection.Reflection;

/**
 * DataManager class will receive the xml(json) file from
 * the player gui and process the file to recreate all the
 * objects specified in the file through specific decoders. 
 * All the game elements will be packed into "GameElement" object 
 * and be sent to the game player.
 * 
 * @author Seunghyun Lee
 *
 */

public class DataManager {
    
    private Element myRoot;
    private GameMap myGameMap;
    private List<Unit> myUnits;
    private List<Player> myPlayers;
    
    private Map<String,Decoder> myDecoders;
    private Map<String,String> myImageResources;

    
    public DataManager(File xmlFile) {
        myDecoders = new HashMap<String,Decoder>();
        myImageResources = new HashMap<String,String>();
        try {
            initXmlFile(xmlFile);
            initDecoders();
            processDecoders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sets the root element to the data manager class.
     * Input will be the user selected xml file that is received 
     * from the player GUI.
     * 
     * @param xml
     */
    private void initXmlFile(File xml) {
        try {
            Document doc = getDocument(xml);
            doc.getDocumentElement().normalize();
            myRoot = doc.getDocumentElement();
        } catch(Exception e) {
            e.printStackTrace();
        }
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
    public Document getDocument(File xml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xml);
        return doc;  
    }
    
    /**
     * Use reflection to create all the decoders.
     */
    private void initDecoders() {
        //hard code for the test use
        myDecoders.put("MapDecoder", new MapDecoder(this));
        
    }
    private void processDecoders() {
        //for (String key: myDecoders.keySet()) {
        //    myDecoders.get(key).load(myRoot);
        //}
        myDecoders.get("MapDecoder").load((Element)myRoot.getElementsByTagName("map").item(0));
        //use for each loop, having an arraylist or map of 
    }
    

    //get & set methods
    public void setGameMap(GameMap map){
        myGameMap = map;
    }
    
    public GameMap getGameMap() {
        return myGameMap;
    }
    
    /**
     * Serialized objects are packed into GameElements object, which is
     * passed to GameLoader from the game player.
     *  
     * @return GameElements
     */
    public GameElements getGameElements() {
        return new GameElements(myGameMap);
    }
    
    //Test Use
    public static void main(String[] args) throws ObjectWriteException {
        DataManager fac = new DataManager(new File("src/data/resources/test_game.xml"));
        GameElements ele = fac.getGameElements();
        GameMap map = ele.getGameMap();
        
        
        
        
        Attributes attr = new Attributes();
        System.out.println(attr.getField());
    }
}
