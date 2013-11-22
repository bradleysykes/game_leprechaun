package data.encoder;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import model.GameMap;
import model.Player;
import data.Elements;
import data.GameElements;

//Place Holder Class for Save method in gae.controller
public class SaveHandler implements Elements {
	
    private Encoder myMapEncoder, myPlayerEncoder;
    Document myXmlDocument;
	
    public SaveHandler() {
        
    }
    
    /**
     * Save the information from the current GameElement by encoding it into an
     * XML file and then saving it to disc  
     * @param currentState
     */
	public void doSave(GameElements currentState) {
	    myXmlDocument = initializeDocument();
	    Element root = myXmlDocument.createElement(GAME_ELEMENTS);
        myXmlDocument.appendChild(root);
	    
	    myMapEncoder = new MapEncoder(myXmlDocument, currentState.getGameMap(), root);
	    myMapEncoder.encode();
	    
        myPlayerEncoder = new PlayerEncoder(myXmlDocument, currentState.getPlayers(), root);
        myPlayerEncoder.encode();
        
        saveXML("name", myXmlDocument);
	}
	
	/**
	 * Create a new XML document that will be added to
	 * @return
	 */
	private Document initializeDocument() {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder.newDocument();
	}
	
	
	/**
	 * Save the XML file to disc
	 */
    public void saveXML(String filename, Document doc) {
	    
	}
    
    //for testing; create an instance of the GameElements object
    public static void main(String[] args) {
        SaveHandler sh = new SaveHandler();
        GameElements currentState = new GameElements();
        GameMap map = new GameMap(3,3);
        currentState.setGameMap(map);
        List<Player> playerList = new ArrayList<Player>();
        Player p1 = new Player();
        Player p2 = new Player();
        playerList.add(p1); playerList.add(p2);
        currentState.setPlayerList(playerList);
        sh.doSave(currentState);
    }
	
}
