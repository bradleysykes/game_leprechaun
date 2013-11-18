package gae;

import gae.dialogues.PlayerDialogue;
import gae.panels.EditPanel;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.BoardSizeTaskViewItem;
import gae.viewitems.PlayerTaskViewItem;
import gae.viewitems.TaskViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.things.Stat;

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

}
