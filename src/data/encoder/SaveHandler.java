package data.encoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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

/**
 * This is the class that handles the XML saving process when the user chooses to
 * export an XML file of the current state from the game authoring environment.
 * It initializes the necessary encoders, converts information stored in the 
 * given GameElements object into an XML file, and saves the file to disk using the 
 * provided path.
 * 
 * @author Alex Song 
 */
public class SaveHandler implements Elements {
	
    private Encoder myMapEncoder, myPlayerEncoder, myUnitEncoder;
    private String myFilePath;
    private GameElements myCurrentState;
	
    /**
     * Initializes GameElements object that holds the current state, and initializes
     * the path to which the resulting xml file should be saved
     * @param currentState
     * @param filePath
     */
    public SaveHandler(GameElements currentState, String filePath) {
        myFilePath = filePath;
        myCurrentState = currentState;
    }
    
    /**
     * Save the information from the current GameElement by encoding it into an
     * XML file and then saving it to disc  
     * @param currentState
     */
	public void doSave() {
	    Document xmlDocument = initializeDocument();
        initializeEncoders(myCurrentState, xmlDocument);
	    performEncoding();
        saveXmlToFile(xmlDocument);
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
        Document xmlDocument = builder.newDocument();
        Element root = xmlDocument.createElement(GAME_ELEMENTS);
        xmlDocument.appendChild(root);
        return xmlDocument;
    }
	
	/**
	 * Initialize the encoders using the current GameElements object
	 * @param currentState the GameElements object to create the XML file from 
	 * @param the xmlDocument to write to
	 */
	private void initializeEncoders (GameElements currentState, Document xmlDocument) {
	    Element root = (Element) xmlDocument.getFirstChild();
	    myMapEncoder = new MapEncoder(xmlDocument, currentState.getGameMap(), root);
	    myPlayerEncoder = new PlayerEncoder(xmlDocument, currentState.getPlayers(), root);
	    myUnitEncoder = new UnitEncoder(xmlDocument, currentState.getPlayers(), root);
    }
	
	/**
	 * Performs the encoding using the appropriate encoders
	 */
    private void performEncoding () {
        myMapEncoder.encode();
        myPlayerEncoder.encode();
        myUnitEncoder.encode();
    }

	/**
	 * Save the XML file to disk
	 * @param doc xml document to save
	 * @throws FileNotFoundException 
	 * @throws TransformerException 
	 */
    private void saveXmlToFile(Document doc) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(myFilePath));
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = formatXML(tFactory.newTransformer());
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        //use fos for saving to file; use System.out for printing to console
        try {
            transformer.transform(new DOMSource(doc), new StreamResult(fos));
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
	}
    
    /**
     * Formats the XML file to omit XML Declaration and create indentations 
     * @param transformer
     * @return
     */
    private Transformer formatXML(Transformer transformer) {
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        return transformer;
    }
    
}
