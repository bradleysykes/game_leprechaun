package gae;

import gae.dialogues.PlayerDialogue;
import gae.panel_lists.BoardList;
import gae.panels.EditPanel;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.BoardSizeTaskViewItem;
import gae.viewitems.PlayerTaskViewItem;
import gae.viewitems.TaskViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import sun.nio.cs.ext.JIS_X_0201.Encoder;
import data.GameElements;
import data.encoder.SaveHandler;
import model.Player;
import model.stats.Stat;
import model.unit.Unit;

public class Controller implements Constants{
	
	private List<EditPanel> myPanels = new ArrayList<EditPanel>();
	private List<Player> myPlayers = new ArrayList<Player>();
	
	public Controller(){
		
	}
	
	public void init(){
		if(myPlayers.size()==0){
			this.addViewItem(new PlayerTaskViewItem(this));
			this.addViewItem(new BoardSizeTaskViewItem(this));
		}
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
	
	public void removeBoardObject(BoardListViewItem item){
		for(EditPanel p:myPanels){
			p.removeBoardObject(item);
//			for(Player p:myPlayers){
//			List<Unit> units = p.getAllUnits();
//			Object toRemove = item.getModelObject();
//			List<Unit> copy = new ArrayList<Unit>();
//			for(Unit u:units){
//				if(u.getID()!=((Unit)toRemove).getgetID()){
//					copy.add(u);
//				}
//			}
//			units=copy;
//		}}
//	
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
	
	public void getAndSaveState() {
		GameElements currentState = new GameElements();
		for(EditPanel p:myPanels){
			currentState = p.giveStateObjects(currentState);
			if (currentState == null) {
				// Popup dialog->not saved
				JOptionPane alertPane = new JOptionPane("Please complete all tasks before saving.");
				JDialog dialog = alertPane.createDialog(null,"Save alert");
				dialog.setLocation(10, 10);
				dialog.setVisible(true);
				return;
			}
		}
		int returnVal = FILE_CHOOSER.showOpenDialog(myPanels.get(0));
	    String filePath = FILE_CHOOSER.getSelectedFile().getAbsolutePath();
	    SaveHandler saveHandler = new SaveHandler(currentState, filePath);
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

	public void displayFile(File file) {
		for(EditPanel p:myPanels){
			p.displayFile(file);
		}
	}

}
