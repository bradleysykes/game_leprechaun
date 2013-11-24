package data.encoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
	
    private List<Encoder> myEncoderList;
    private Document myXmlDocument;
    private GameElements myCurrentState;
    private String myFilePath;
    
    /**
     * Initializes GameElements object that holds the current state, sets the path
     * to which the resulting xml file should be saved, and initializes a list
     * of encoders
     * @param currentState
     * @param filePath
     */
    public SaveHandler(GameElements currentState, String filePath) {
        myFilePath = filePath;
        myCurrentState = currentState;
        myEncoderList = new ArrayList<Encoder>();
    }
    
    
    
    /**
     * Save the information from the current GameElement by encoding it into an
     * XML file and then saving it to disc  
     */
	public void doSave() {
	    initializeDocument();
        initializeEncoders();
	    performEncoding();
        saveXmlToFile();
	}
	
    /**
     * Create a new XML document and append a root node
     * @return
     */
    private void initializeDocument() {
        try {
            myXmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = myXmlDocument.createElement(GAME_ELEMENTS);
            myXmlDocument.appendChild(root);
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Initialize the encoders using the current GameElements object and store them
	 * in a list
	 */
	private void initializeEncoders () {
	    Element root = (Element) myXmlDocument.getFirstChild();
	    myEncoderList.add(new MapEncoder(myXmlDocument, myCurrentState.getGameMap(), root));
	    myEncoderList.add(new PlayerEncoder(myXmlDocument, myCurrentState.getPlayers(), root));
	    myEncoderList.add(new UnitEncoder(myXmlDocument, myCurrentState.getPlayers(), root));
    }
	
	/**
	 * Performs the encoding using the appropriate encoders
	 */
    private void performEncoding () {
        for(Encoder encoder : myEncoderList) {
            encoder.encode();
        }
    }

	/**
	 * Save the XML file to disk
	 * @throws FileNotFoundException 
	 * @throws TransformerException 
	 */
    private void saveXmlToFile() {
        //use fos for saving to file; use System.out for printing to console
        try {
            Transformer transformer = formatXML(TransformerFactory.newInstance().newTransformer());
            FileOutputStream fos = new FileOutputStream(new File(myFilePath));
            transformer.transform(new DOMSource(myXmlDocument), new StreamResult(fos));
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
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
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        return transformer;
    }
    
}
