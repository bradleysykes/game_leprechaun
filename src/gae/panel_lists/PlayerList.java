package gae.panel_lists;

import java.io.File;
import java.util.List;

import data.GameElements;

import model.Player;
import model.stats.Stat;
import gae.control.Controller;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.PlayerPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.ViewItem;

public class PlayerList extends BoardList {
	
	public PlayerList(Controller controller) {
		super(controller);
	}

	@Override
	@Deprecated
	public String getPackageName() {
		return "";
	}
	
	@Override
	public GAEPopupMenu getPopupMenu(){
		return new PlayerPopupMenu(myController,this);
	}

	@Override
	public String getListType() {
		return "";
	}
	@Override
	public void addNewItem(ViewItem item){
		myModel.insertElementAt(item, myModel.size());
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,
			File f, int counter) {
		Player newPlayer = new Player(name);
		newPlayer.setID(name);
		newPlayer.setStats(inputData);
		PlayerViewItem pvi = new PlayerViewItem(newPlayer);
		this.addNewItem(pvi);
		return new NullViewItem();
	}
	
	@Override
	public void loadData(GameElements elements){
		List<Player> loadPlayers = elements.getPlayers();
		if(loadPlayers!=null){
			int i = 1;
			for(Player player:loadPlayers){
				this.addNewItem(new PlayerViewItem(player,i));
				i++;
			}
		}
	}
}
