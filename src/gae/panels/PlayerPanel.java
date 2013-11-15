package gae.panels;


import gae.Controller;
import gae.panel_lists.BoardList;
import gae.panel_lists.PlayerList;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.ViewItem;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Player;
import model.things.Thing;

public class PlayerPanel extends EditPanel {
	private PlayerList myList;

	public PlayerPanel(Controller controller){
		super(controller);
		myList = new PlayerList(controller);
		this.add(myList);
	}

	@Override
	public void postProperties(List<Thing> properties) {
		//do nothing
		
	}

	@Override
	public void postPlayers(List<Player> myPlayers) {
		for(Player p:myPlayers){
			myList.addNewItem(new PlayerViewItem(p));
		}	
	}

	@Override
	public void addViewItem(ViewItem item) {
		// TODO Auto-generated method stub
		
	}

}
