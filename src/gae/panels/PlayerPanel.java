package gae.panels;


import gae.Controller;
import gae.panel_lists.BoardList;
import gae.panel_lists.PlayerList;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.ViewItem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Player;
import model.things.Thing;

public class PlayerPanel extends EditPanel {
	private PlayerList myList;
	private List<Player> myModelPlayerList;

	public PlayerPanel(Controller controller){
		super(controller);
		myList = new PlayerList(controller);
		myModelPlayerList = new ArrayList<Player>();
		this.add(myList);
	}

	@Override
	public void postProperties(List<Thing> properties) {
		//do nothing
		
	}

	@Override
	public void postPlayers(int numPlayers) {
		while(myModelPlayerList.size()<numPlayers) {
			Player nextPlayer = new Player();
			myList.addNewItem(new PlayerViewItem(nextPlayer));
			myModelPlayerList.add(nextPlayer);
		}
		while(myModelPlayerList.size()>numPlayers) {
			myList.removeItem(numPlayers);
			myModelPlayerList.remove(numPlayers);
		}
	}

	@Override
	public void addViewItem(ViewItem item) {
		// TODO Auto-generated method stub
		
	}

}
