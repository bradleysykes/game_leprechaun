package data.decoder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import data.Attributes;
import data.Elements;
import data.GameElements;
import model.GameMap;
import model.Player;
import model.unit.Unit;

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

public class DataManager implements Attributes, Elements {
    private Element myRoot;
    private GameMap myGameMap;
    private List<Unit> myUnits;
    private List<Player> myPlayers;
    
    private Map<String,Decoder> myDecoders;
    private Map<String,String> myImageResources;
    
    
    public DataManager() {
        myDecoders = new HashMap<String,Decoder>();
        myImageResources = new HashMap<String,String>();
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
        myDecoders.get("MapDecoder").decodeData((Element)myRoot.getElementsByTagName(MAP_ROOT).item(0));
        //myDecoders.get("UnitDecoder").decodeData((Element)myRoot.getElementsByTagName(UNIT_ROOT).item(0));

    }
    
    /**
     * Serialized objects are packed into GameElements object, which is
     * passed to GameLoader from the game player.
     *   
     * @return GameElements
     */
    public GameElements getGameElements(File xmlFile) {
        try {
            //converts xml file object to dom document object
            initXmlFile(xmlFile);
            //calls decoders to instantiate the game elements
            processDecoders();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new GameElements(myGameMap);
    }
    
    //get & set methods
    public void setGameMap(GameMap map){
        myGameMap = map;
    }
    
    public GameMap getGameMap() {
        return myGameMap;
    }
    
    public void setUnits(List<Unit> units) {
        myUnits = units;
    }
    
    public static void main(String[] args) {
        DataManager dm = new DataManager();
        GameElements map = dm.getGameElements(new File("src/data/resources/map.xml"));
        map.toString();
    }
}
