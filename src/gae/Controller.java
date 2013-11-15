package gae;

import gae.dialogues.PlayerDialogue;
import gae.panels.EditPanel;
import gae.viewitems.TaskViewItem;
import gae.viewitems.ViewItem;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.things.Thing;

public class Controller {
	
	List<EditPanel> myPanels = new ArrayList<EditPanel>();
	List<Player> myPlayers = new ArrayList<Player>();
	
	public Controller(){

	}
	
	public void init(){
		if(myPlayers.size()==0){
			this.addViewItem(new TaskViewItem("Specify number of players", this));
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
	
	public void postPlayers(int numPlayers){
		for(EditPanel p:myPanels){
			p.postPlayers(numPlayers);
		}
			
	}
	
	public void postProperties(List<Thing> props){
		for(EditPanel p:myPanels){
			p.postProperties(props);
		}
	}
	
	public void removeTask(TaskViewItem tvi) {
		for(EditPanel p:myPanels){
			p.removeTask(tvi);
		}
	}

}
