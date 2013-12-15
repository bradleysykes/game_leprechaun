package gae.control;

import gae.Constants;
import gae.dialogues.PlayerDialogue;
import gae.menu_bar.EditMenuBar;
import gae.panel_lists.BoardList;
import gae.panels.EditPanel;
import gae.view.EditGUI;
import gae.view.EditToolbar;
import gae.view.LaunchGUI;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.BoardSizeTaskViewItem;
import gae.viewitems.FillTaskViewItem;
import gae.viewitems.PlayerTaskViewItem;
import gae.viewitems.TaskViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import sun.audio.AudioPlayer;
import sun.nio.cs.ext.JIS_X_0201.Encoder;
import data.GameElements;
import data.encoder.SaveHandler;
import engine.GameViewer;
import model.GameMap;
import model.Player;
import model.Resource;
import model.stats.Stat;
import model.unit.Unit;

/**
 * Controls communication between Swing components
 *
 * @author Will
 * @author Brad
 */
public class Controller implements Constants{
	
	private List<EditPanel> myPanels = new ArrayList<EditPanel>();
	private List<Player> myPlayers = new ArrayList<Player>();
	private String myGameFilePath;
	private GameElements myCurrentState;
	private EditGUI myGUI;
	private EditMenuBar myMenuBar;
	private Controller myController;
	private EditToolbar myToolbar;
	private boolean saved = false;
	
	/**
	 * Initializes controller and save timer
	 */
	public Controller(){
		myController = this;
		Timer timer = new Timer(200000, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(myController.canSave()){
					myController.save();
					System.out.println("Game saved at"+System.currentTimeMillis());
				}
			}
		});
		timer.start();
	}
	
	/**
	 * sets the GUI to the given EditGUI
	 * 
	 * @param gui
	 */
	public void setGUI(EditGUI gui){
		myGUI = gui;
	}
	
	/**
	 * Used to add TaskViewItems to TaskPanel on startup
	 */
	public void init(){
		this.addViewItem(new PlayerTaskViewItem(this));
		this.addViewItem(new BoardSizeTaskViewItem(this));
		this.addViewItem(new FillTaskViewItem(this));
	}
	
	/**
	 * Calls the addViewItem method on each EditPanel.  EditPanels will process
	 * the correct type
	 * 
	 * @param item
	 */
	private void addViewItem(ViewItem item) {
		for(EditPanel p:myPanels){
			p.addViewItem(item);
		}
	}
	
	public void clearMap(){
		for(Player player:myPlayers){
			player.getAllUnits().clear();
		}
	}
	
	/**
	 * update model to reflect removal of certain objects from game. 
	 * @param item
	 */
	public void removeBoardObject(BoardListViewItem item){
		// update the panels appropriately 
		for(EditPanel p:myPanels){
			p.removeBoardObject(item);
		}
	}

	/**
	 * Adds an EditPanel to the Controller collection
	 * @param panel
	 */
	public void addPanel(EditPanel panel){
		myPanels.add(panel);
	}
	
	/**
	 * Sets the players in the Controller to the given List<Player>
	 * @param players
	 */
	public void setPlayer(List<Player> players){
		myPlayers = players;
	}
	
	/**
	 * Empty method...
	 */
	public void postBoardData(){
		
	}
	
	/**
	 * Posts the number of players to the EditPanels, allows altering of number
	 * while keeping remaining players
	 * @param numPlayers
	 */
	public void postPlayers(int numPlayers){
		for(EditPanel p:myPanels){
			p.postPlayers(numPlayers);
		}
		myToolbar.enablePlayerEdit();
			
	}
	
	/**
	 * Posts the list of stats to the correct panel (Object Panel)
	 * @param props
	 */
	public void postProperties(List<Stat> props){
		for(EditPanel p:myPanels){
			p.postProperties(props);
		}
	}
	
	/**
	 * Removes the TaskViewItem of the same type as tvi from the TaskPanel
	 * @param tvi
	 */
	public void removeTask(TaskViewItem tvi) {
		for(EditPanel p:myPanels){
			p.removeTask(tvi);
		}
	}
	
	/**
	 * Creates a map based on a list of Strings that holds the length and width
	 * dimensions
	 * @param data
	 */
	public void createMap(List<String> data){
		for(EditPanel p:myPanels){
			p.createMap(data);
		}
		myToolbar.enableResize();
	}
	
	/**
	 * Saves the game to the file at the last selected path
	 */
	public void save(){
		getAndSaveState(myGameFilePath);
	}
	
	/**
	 * returns true if TaskPanel has no more items, false if there are items
	 * left
	 * @return
	 */
	public boolean canSave(){
		myCurrentState = new GameElements();
		for(EditPanel p:myPanels){
			myCurrentState = p.giveStateObjects(myCurrentState);
			if (myCurrentState == null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Alerts the user that they are not able to save at when all tasks are not
	 * complete
	 */
	public void alertSave(){
		JOptionPane alertPane = new JOptionPane("Please complete all tasks before saving.");
		JDialog dialog = alertPane.createDialog(null,"Save alert");
		dialog.setLocation(10, 10);
		dialog.setVisible(true);
	}
	
	/**
	 * performs a save to the given file path
	 * @param filePath
	 */
	public void getAndSaveState(String filePath) {
		if(!canSave()){
			alertSave();
			return;
		}
		if(filePath==""){
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "XML only", "xml");
			FILE_CHOOSER.setFileFilter(filter);
			int returnVal = FILE_CHOOSER.showOpenDialog(myPanels.get(0));
		    myGameFilePath = FILE_CHOOSER.getSelectedFile().getAbsolutePath();
		}
		else{
			myGameFilePath = filePath;
		}
	    SaveHandler saveHandler = new SaveHandler(myCurrentState, myGameFilePath);
		saveHandler.doSave();
		this.saved = true;
		// create data object to send GameElements object to that.
	}
	
	public boolean hasSaved(){
		return saved;
	}
	
	public boolean hasSavePath(){
		return myGameFilePath!=null;
	}

	/**
	 * fills the GameMap and the GUIMap with the Model and JGame versions of the
	 * given ViewItem, respectively
	 * @param mySource
	 */
	public void fillBoard(ViewItem mySource) {
		for(EditPanel p:myPanels){
			p.fillBoard(mySource);
		}
	}
	
	/**
	 * Gets and returns the Model versions of the players current to the GAE
	 * @return
	 */
	public List<Player> getPlayers(){
		List<Player> players = null;
		for(EditPanel p:myPanels){
			players = p.getPlayers();
			if (players!=null) {
				break;
			}
		}
		return players;
	}

	/**
	 * Gets and returns a Model version of each unit type defined in the game
	 * @return
	 */
	public List<Unit> getUnitTypes() {
		List<Unit> units = null;
		for(EditPanel p:myPanels){
			units = p.getUnitTypes();
			if (units!=null) {
				break;
			}
		}
		return units;
	}
	
	/**
	 * Returns the GameMap in its current state.  Returns null if the GameMap
	 * does not exist yet
	 * @return
	 */
	public GameMap getMap() {
		GameMap map = null;
		for(EditPanel p:myPanels) {
			map = p.getMap();
			if (map!=null) {
				return map;
			}
		}
		return null;
	}

	/**
	 * Displays the .xml file at the current save state path
	 */
	public void displayFile() {
		for(EditPanel p:myPanels){
			p.displayFile(new File(myGameFilePath));
		}
	}

	/**
	 * Closes the GUIMap to allow the user to switch from the GAE to the Engine
	 */
	public void closeMap() {
		for(EditPanel p:myPanels){
			p.closeMap();
		}
	}

	/**
	 * Autosaves if possible, then opens the LaunchGUI and closes GAE
	 */
	public void exit() {
		if(canSave()){
			this.save();
		}
		InputStream stream = myGUI.getInputStream();
		AudioPlayer.player.stop(stream);
		myGUI.dispose();
		new LaunchGUI();
	}
	
	public boolean hasExited(){
		return myGUI.isShowing();
	}

	/**
	 * Opens an .xml file to a new EditGUI
	 */
	public void open() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "XML Files", "xml");
		FILE_CHOOSER.setFileFilter(filter);
		if(FILE_CHOOSER.showOpenDialog(myPanels.get(0))==JFileChooser.APPROVE_OPTION){
	    	String openPath = FILE_CHOOSER.getSelectedFile().getAbsolutePath();
	    	closeMap();
	    	InputStream stream = myGUI.getInputStream();
			AudioPlayer.player.stop(stream);
	    	myGUI.dispose();
	    	new EditGUI(openPath);
	    	
		}
	}
	
	/**
	 * Launches a new Engine to run the current file path
	 */
	public void launchGame(){
		new GameViewer().launch(myGameFilePath);
	}
	
	/**
	 * Sets the current file path to the given filePath
	 * @param filePath
	 */
	public void setGameFilePath(String filePath){
		myGameFilePath = filePath;
		myMenuBar.activateSaveItem();
	}

	/**
	 * Sets everything in the GAE to the GameElements positions
	 * @param openElements
	 */
	public void loadData(GameElements openElements) {
		myPlayers = openElements.getPlayers();
		for(EditPanel p:myPanels){
			p.loadData(openElements);
		}
	}

	/**
	 * Sets the stored MenuBar to the given one
	 * @param editMenuBar
	 */
	public void setMenuBar(EditMenuBar editMenuBar) {
		myMenuBar = editMenuBar;
	}

	/**
	 * Adds the given resource to every player with a default amount of 0.
	 * @param resource
	 */
	public void addResourceToPlayers(Resource resource) {
		for(EditPanel p:myPanels){
			p.addResource(resource);
		}
	}

	/**
	 * Sets the stored Toolbar to the given one
	 * @param editToolbar
	 */
	public void setToolbar(EditToolbar editToolbar) {
		myToolbar = editToolbar;
	}

}
