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
		if(myPlayers.size()==0){
			this.addViewItem(new TaskViewItem());
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
	
	public void postPlayers(){
		for(EditPanel p:myPanels){
			p.postPlayers(myPlayers);
		}
			
	}
	
	public void postProperties(List<Thing> props){
		for(EditPanel p:myPanels){
			p.postProperties(props);
		}
	}

}
