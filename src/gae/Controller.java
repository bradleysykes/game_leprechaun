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

import java.util.ArrayList;
import java.util.List;

import sun.nio.cs.ext.JIS_X_0201.Encoder;
import data.GameElements;
import data.encoder.SaveHandler;
import model.Player;
import model.stats.Stat;

public class Controller {
	
	List<EditPanel> myPanels = new ArrayList<EditPanel>();
	List<Player> myPlayers = new ArrayList<Player>();
	
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
	
	public void removeBoardObject(BoardListViewItem item){
		for(EditPanel p:myPanels){
			p.removeBoardObject(item);
		}
	}

	public void addPanel(EditPanel panel){
		myPanels.add(panel);
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
				return;
			}
		}
		
		SaveHandler saveHandler = new SaveHandler(currentState, "./src/data/resources/savedState.xml");
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
			players= p.getPlayers();
			if (players!=null) {
				break;
			}
		}
		return players;
	}

}
