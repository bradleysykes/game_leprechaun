package gae.popup_menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.Player;
import model.unit.Unit;
import gae.Controller;
import gae.panel_lists.BoardList;
import gae.viewitems.PlayerViewItem;

public class PlayerPopupMenu extends GAEPopupMenu {
	
	private BoardList myListSource;
	
	public PlayerPopupMenu(Controller controller, BoardList source) {
		super(controller);
		myListSource = source;
		initialize();
	}
	
	public List<Unit> getPlayers(){
		PlayerViewItem item = (PlayerViewItem)mySource;
		if(item!=null){
			return item.getPlayer().getAllUnits();
		}
		return new ArrayList<Unit>();
	}

	@Override
	public void subInitialize() {
		JMenu unitsSubMenu = new JMenu("View Units");
		this.add(unitsSubMenu);
		for(Unit u:this.getPlayers()){
			JMenuItem unitItem = new JMenuItem(u.getID());
			unitsSubMenu.add(unitItem);
		}
	}

}
