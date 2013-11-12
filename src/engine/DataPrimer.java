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
	
	public DataPrimer() {
		myFileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files Only", "xml");
		myFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		myFileChooser.setFileFilter(filter);
		File xmlFile = selectAndParseXML();
		loadGame(xmlFile);
	}
	
	private File selectAndParseXML() {
		int value = myFileChooser.showOpenDialog(new JFrame()); //needs a parent component.. probably the GAE
		File xmlFile = null;
		if (value == myFileChooser.APPROVE_OPTION) {
			xmlFile = myFileChooser.getSelectedFile();
			return xmlFile;
		}
		return xmlFile;
	}
	
	private void loadGame(File xmlFile) {
		new GameEngine(xmlFile);
	}
	
	
	
	
}
