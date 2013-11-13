package data.decoder;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import model.GameMap;
import model.unit.Unit;
import engine.GameEngine;

/**
 * Factory class. This class will receive the xml(json) file from
 * the player gui and process the file to recreate all the
 * objects specified in the file through specific decoders. 
 * All the game elements will be packed into "GameElement" object 
 * and be sent to the game player.
 * 
 * @author Seunghyun Lee
 *
 */

public class DataManager {
    
    Element myRoot;
    GameMap myGameMap;
    Collection<Unit> myUnits;
    Map<String,Decoder> myDecoders;
    
    public DataManager(File xmlFile) {
        myDecoders = new HashMap<String,Decoder>();
        try {
            initXmlFile(xmlFile);
            initDecoders();
        } catch (Exception e) {
            e.printStackTrace();
        }
        processMap();
    }
    
    private void initXmlFile(File xml) throws ParserConfigurationException, SAXException, IOException {
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
    private void processMap() {
        myDecoders.get("MapDecoder").load((Element)myRoot.getElementsByTagName("map").item(0));
    }
        
    public void processUnits() {
        
    }
    
    public void setGameMap(GameMap map) {
        myGameMap = map;
    }
    
    public GameElements getGameElements() {
        return new GameElements(myGameMap);
    }
    
    //Test Use
    public static void main(String[] args) {
        DataManager fac = new DataManager(new File("src/data/resources/test_game.xml"));
        GameElements ele = fac.getGameElements();
        GameMap map = ele.getGameMap();
    }
}
