package data.encoder;

import java.io.FileNotFoundException;
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
import model.Resource;
import model.tile.Tile;
import model.unit.Unit;
import data.Elements;
import data.GameElements;

//Place Holder Class for Save method in gae.controller
public class SaveHandler implements Elements {
	
    private Encoder myMapEncoder, myPlayerEncoder, myUnitEncoder;
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
        
        myUnitEncoder = new UnitEncoder(myXmlDocument, currentState.getPlayers(), root);
        myUnitEncoder.encode();
        
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
        Transformer transformer = formatXML(tFactory.newTransformer());
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
        
        //add map to currentState
        GameMap map = new GameMap(3,3);
        Resource minerals = new Resource("minerals", 50, 2);
        Resource gas = new Resource("gas", 50, 2);
        for(Tile tile : map.getAllTiles()) {
            tile.getStatCollection(RESOURCES).addStat(minerals);
            tile.getStatCollection(RESOURCES).addStat(gas);
        }
        currentState.setGameMap(map);
        
        //add playerList to currentState
        List<Player> playerList = new ArrayList<Player>();
        Player p1 = new Player();
        p1.getStatCollection(RESOURCES).addStat(new Resource("minerals", 500, 0));
        p1.getStatCollection(RESOURCES).addStat(new Resource("gas", 350, 0));
        Unit unit1 = new Unit("unit1",p1,map);
        Tile t1 = new Tile(2,1,map);
        unit1.setCurrentTile(t1);
        p1.addUnit(unit1);
        
        Player p2 = new Player();
        p2.getStatCollection(RESOURCES).addStat(new Resource("minerals", 820, 0));
        p2.getStatCollection(RESOURCES).addStat(new Resource("gas", 620, 0));
        Unit unit2 = new Unit("unit2",p2,map);
        Tile t2 = new Tile(1,0,map);
        unit2.setCurrentTile(t2);
        p1.addUnit(unit2);
        
        playerList.add(p1); playerList.add(p2);
        currentState.setPlayerList(playerList);
        
        
        //save to XML file
        sh.doSave(currentState);
    }
	
}
