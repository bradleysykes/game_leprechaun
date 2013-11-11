package engine;

import java.io.File;
import java.util.Collection;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 * Uses the XMLParser to retrieve data about objects from XML file.
 * @author Dylan and Bernard
 *
 */

public class DataPrimer {
	
	private JFileChooser myFileChooser;
	private Collection<Object> myGameObjectInfo;
	
	public DataPrimer() {
		myFileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files Only", "xml");
		myFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		myFileChooser.setFileFilter(filter);
		selectAndParseXML();
	}
	
	private void selectAndParseXML() {
		//call gamedata's xml parser here to populate myGameObjectInfo
		int value = myFileChooser.showOpenDialog(new JFrame()); //needs a parent component.. probably the GAE
		if (value == myFileChooser.APPROVE_OPTION) {
			File xmlFile = myFileChooser.getSelectedFile();
			//myGameObjectInfo = GameDataParser.parseXMLFile(xmlFile);   //Parser class isnt available yet
		}
	}
	
	public Collection<Object> getGameObjectInfo() {
		return myGameObjectInfo;
	}
	
	
	
}
