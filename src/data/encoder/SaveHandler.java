package data.encoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
        
        try {
            saveXML("name", myXmlDocument);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
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
	 * @throws FileNotFoundException 
	 * @throws TransformerException 
	 */
    public void saveXML(String filename, Document doc) throws FileNotFoundException, TransformerException {
        //FileOutputStream fos = new FileOutputStream(new File("test.xml"));
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        transformer = formatXML(tFactory.newTransformer());
        //use fos for saving to file; use System.out for printing to console
        transformer.transform(new DOMSource(myXmlDocument), new StreamResult(System.out));
	}
    
    /**
     * Formats the XML file to omit XML Declaration and create indentations 
     * @param transformer
     * @return
     */
    protected Transformer formatXML(Transformer transformer) {
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        return transformer;
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
