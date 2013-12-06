package engine;

import java.io.File;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import data.GameElements;
import data.decoder.DataManager;
import data.decoder.DataManager;

public class DataPrimer {
	
	private JFileChooser myFileChooser;
	private GameEngine myGameEngine;
	
	public DataPrimer(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myFileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files Only", "xml");
		myFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		myFileChooser.setFileFilter(filter);
		File xmlFile = selectAndParseXML();
/*		if(gameEngine.getSourceFile()!=null){
			xmlFile = gameEngine.getSourceFile();
		}
		else{
			xmlFile = new File("src/test_saves/game3.xml");
		}*/
		//File xmlFile = new File("src/test_saves/hihi.xml");

		System.out.println("Loading from file "+xmlFile.getAbsolutePath());
		loadGame(xmlFile);
	}
	
	private File selectAndParseXML() {
		int value = myFileChooser.showOpenDialog(myGameEngine);
		File xmlFile = null;
		if (value == myFileChooser.APPROVE_OPTION) {
			xmlFile = myFileChooser.getSelectedFile();
			return xmlFile;
		}
		return xmlFile;
	}
	
	private void loadGame(File xmlFile) {
		DataManager dataManager = new DataManager();

		GameElements gameElements = dataManager.getGameElements(xmlFile);
		myGameEngine.initializeState(gameElements);
	}
	
	
	
	
}
