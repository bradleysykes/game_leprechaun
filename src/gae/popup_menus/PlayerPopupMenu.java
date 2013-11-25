package gae.popup_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.Player;
import model.unit.Unit;
import gae.Controller;
import gae.dialogues.EditDialogue;
import gae.panel_lists.BoardList;
import gae.viewitems.NullViewItem;
import gae.viewitems.PlayerViewItem;

public class PlayerPopupMenu extends GAEPopupMenu {
	
	private BoardList myListSource;
	private JMenu myUnitsSubMenu;
	
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
	public void populate(){
		myUnitsSubMenu.removeAll();
		for(Unit u:this.getPlayers()){
			String unitID = u.getID();
			String unitName = unitID.substring(0, unitID.indexOf("|"));
			JMenuItem unitItem = new JMenuItem(unitName);
			unitItem.addActionListener(new UnitPropertyListener(u));
			myUnitsSubMenu.add(unitItem);
		}
	}
	
	@Override
	public void subInitialize() {
		myUnitsSubMenu = new JMenu("View Units");
		this.add(myUnitsSubMenu);
	}
	
	public class UnitPropertyListener implements ActionListener {
		private Unit myUnit;
		
		public UnitPropertyListener(Unit unit){
			myUnit = unit;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			EditDialogue d = new EditDialogue(myUnit.getID(),myUnit.getStats(), new NullViewItem());
		}
	}

}
