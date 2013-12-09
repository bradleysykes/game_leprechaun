package gae.panels;


import gae.Controller;
import gae.panel_lists.BoardList;
import gae.panel_lists.PlayerList;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.ViewItem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import data.GameElements;
import model.Player;
import model.Resource;
import model.unit.Unit;

public class PlayerPanel extends EditPanel {
	private PlayerList myList;
	private List<Player> myModelPlayerList;
	private int myPlayerNumber = 1;
	private List<Resource> myGameResources;

	public PlayerPanel(Controller controller){
		super(controller);
		myList = new PlayerList(controller);
		myModelPlayerList = new ArrayList<Player>();
		myGameResources = new ArrayList<Resource>();
		this.add(myList);
		Player p = new Player();
	}

	@Override
	public void postPlayers(int numPlayers) {
		while(myModelPlayerList.size()<numPlayers) {
			Player nextPlayer = new Player("Player "+myPlayerNumber);
			for (Resource r:myGameResources) {
				nextPlayer.addNewResourceType(r.getID(), r.getStat("Harvest Rate").getValue());
			}
			myList.addNewItem(new PlayerViewItem(nextPlayer, myPlayerNumber));
			myModelPlayerList.add(nextPlayer);
			myPlayerNumber++;
		}
		while(myModelPlayerList.size()>numPlayers) {
			myList.removeItem(numPlayers);
			myModelPlayerList.remove(numPlayers);
			myPlayerNumber--;
		}
		myController.setPlayer(myModelPlayerList);
	}
	
	@Override
	public GameElements giveStateObjects(GameElements currentState) {
		currentState.setPlayerList(myModelPlayerList);
		return currentState;
	}
	@Override
	public List<Player> getPlayers() {
		return myModelPlayerList;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return PLAYER_PANEL_TITLE;
	}

	@Override
	public void loadData(GameElements elements) {
		myList.loadData(elements);
	}
	
	@Override
	public void addResource(Resource resource) {
		myGameResources.add(resource);
		for (Player p:myModelPlayerList) {
			p.addNewResourceType(resource.getID(), resource.getStat("Harvest Rate").getValue());
		}
	}
	
	@Override
	public void removeBoardObject(BoardListViewItem item){
		for(Player player:myModelPlayerList){
			List<Unit> oldUnits = player.getAllUnits();
			List<Unit> updatedUnits = new ArrayList<Unit>();
			Unit removedUnit = (Unit)item.getModelObject();
			for(Unit unit:oldUnits){
				if(unit.getID()!=removedUnit.getID()){
					updatedUnits.add(unit);
				}
			}
			//assign new list of players to unit
		}
	}
}
