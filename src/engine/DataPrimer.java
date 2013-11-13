package engine;

import java.io.File;
import java.util.Collection;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import data.decoder.DataManager;
import data.decoder.GameElements;

public class DataPrimer {
	
	private JFileChooser myFileChooser;
	private GameEngine myGameEngine;
	
	public DataPrimer(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myFileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files Only", "xml");
		myFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		myFileChooser.setFileFilter(filter);
		File xmlFile = selectAndParseXML();
		loadGame(xmlFile);
	}
	
	private File selectAndParseXML() {
		int value = myFileChooser.showOpenDialog(myGameEngine); //needs a parent component.. probably the GAE
		File xmlFile = null;
		if (value == myFileChooser.APPROVE_OPTION) {
			xmlFile = myFileChooser.getSelectedFile();
			return xmlFile;
		}
		return xmlFile;
	}
	
	private void loadGame(File xmlFile) {
		DataManager factory = new DataManager(xmlFile);
		GameElements gameElements = factory.getGameElements();
		myGameEngine.initializeState(gameElements);
	}
	
	
	
	
}
