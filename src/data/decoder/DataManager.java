package data.decoder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import model.tile.Tile;
import model.unit.Unit;

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
 * 
 * TODO:
 * 1. put units to tiles  
 * 2. put units to players o
 * 3. put players to units X
 * 4. condition(separate?)
 * 5. put map to units
 */

public class DataManager implements Attributes, Elements {
    private Element myRoot;
    private GameMap myGameMap;
    //private List<Unit> myUnits;
    private List<Player> myPlayers;
    
    private List<Decoder> myDecoders;
    
    private Map<String,String> myTileImageResources;
    private Map<String,String> myUnitImageResources;
    
    
    public DataManager() {
        myDecoders = new ArrayList<Decoder>();
        myTileImageResources = new HashMap<String,String>();
        myUnitImageResources = new HashMap<String,String>();
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
    
    private void initDecoders() {
        myDecoders.add(new MapDecoder(this));
        myDecoders.add(new PlayerDecoder(this));
        myDecoders.add(new UnitDecoder(this));
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
            //converts xml file object to dom document object
            initXmlFile(xmlFile);
            //calls decoders to instantiate the game elements
            processDecoders();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new GameElements(myGameMap, myPlayers);
    }
    
    //get & set methods
    public void setGameMap(GameMap map){
        myGameMap = map;
    }
    
    public GameMap getGameMap() {
        return myGameMap;
    }
/*
    public void setUnits(List<Unit> units) {
        myUnits = units;
    }
*/
    public void setPlayers (List<Player> players) {
        myPlayers = players;
    }
    
    public Player getPlayer(String id) {
        for (Player p : myPlayers) {
            if (p.getID().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    public Tile getTile(int x, int y) {
        return myGameMap.getTile(x,y);
    }
    
    public static void main(String[] args) {
        DataManager dm = new DataManager();
        GameElements map = dm.getGameElements(new File("src/data/resources/test_game.xml"));
        map.toString();
    }
}
