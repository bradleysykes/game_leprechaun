package gae;

import gae.dialogues.PlayerDialogue;
import gae.menu_bar.EditMenuBar;
import gae.panel_lists.BoardList;
import gae.panels.EditPanel;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import sun.nio.cs.ext.JIS_X_0201.Encoder;
import data.GameElements;
import data.encoder.SaveHandler;
import engine.GameViewer;
import model.GameMap;
import model.Player;
import model.Resource;
import model.stats.Stat;
import model.unit.Unit;

public class Controller implements Constants{
	
	private List<EditPanel> myPanels = new ArrayList<EditPanel>();
	private List<Player> myPlayers = new ArrayList<Player>();
	private String myGameFilePath;
	private GameElements myCurrentState;
	private JFrame myGUI;
	private EditMenuBar myMenuBar;
	private Controller myController;
	
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
	
	public void setGUI(JFrame gui){
		myGUI = gui;
	}
	
	public void init(){
		this.addViewItem(new PlayerTaskViewItem(this));
		this.addViewItem(new BoardSizeTaskViewItem(this));
		this.addViewItem(new FillTaskViewItem(this));
	}
	
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

	public void addPanel(EditPanel panel){
		myPanels.add(panel);
	}
	
	public void setPlayer(List<Player> players){
		myPlayers = players;
	}
	
	public void postBoardData(){
		
	}
	
	public void postPlayers(int numPlayers){
		for(EditPanel p:myPanels){
			p.postPlayers(numPlayers);
		}
			
	}
	
	public void postProperties(List<Stat> props){
		for(EditPanel p:myPanels){
			p.postProperties(props);
		}
	}
	
	public void removeTask(TaskViewItem tvi) {
		for(EditPanel p:myPanels){
			p.removeTask(tvi);
		}
	}
	
	public void createMap(List<String> data){
		for(EditPanel p:myPanels){
			p.createMap(data);
		}
	}
	
	public void save(){
		getAndSaveState(myGameFilePath);
	}
	
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
	
	public void alertSave(){
		JOptionPane alertPane = new JOptionPane("Please complete all tasks before saving.");
		JDialog dialog = alertPane.createDialog(null,"Save alert");
		dialog.setLocation(10, 10);
		dialog.setVisible(true);
	}
	
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
		
		// create data object to send GameElements object to that.
	}

	public void fillBoard(ViewItem mySource) {
		for(EditPanel p:myPanels){
			p.fillBoard(mySource);
		}
	}
	
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

	public void displayFile() {
		for(EditPanel p:myPanels){
			p.displayFile(new File(myGameFilePath));
		}
	}

	public void closeMap() {
		for(EditPanel p:myPanels){
			p.closeMap();
		}
		myGUI.dispose();
	}

	public void exit() {
		if(canSave()){
			this.save();
			System.out.println("Game saved to " + myGameFilePath +".");
		}
		myGUI.dispose();
		new LaunchGUI();
	}

	public void open() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "XML Files", "xml");
		FILE_CHOOSER.setFileFilter(filter);
		if(FILE_CHOOSER.showOpenDialog(myPanels.get(0))==JFileChooser.APPROVE_OPTION){
	    	String openPath = FILE_CHOOSER.getSelectedFile().getAbsolutePath();
	    	closeMap();
	    	myGUI.dispose();
	    	new EditGUI(openPath);
	    	
		}
	}
	
	public void launchGame(){
		new GameViewer().launch(myGameFilePath);
	}
	
	public void setGameFilePath(String filePath){
		myGameFilePath = filePath;
		myMenuBar.activateSaveItem();
	}

	public void loadData(GameElements openElements) {
		myPlayers = openElements.getPlayers();
		for(EditPanel p:myPanels){
			p.loadData(openElements);
		}
	}

	public void setMenuBar(EditMenuBar editMenuBar) {
		myMenuBar = editMenuBar;
	}

	public void addResourceToPlayers(Resource resource) {
		for(EditPanel p:myPanels){
			p.addResource(resource);
		}
	}

}
