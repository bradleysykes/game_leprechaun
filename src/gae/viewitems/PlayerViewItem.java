package gae.viewitems;

import gae.Controller;
import gae.dialogues.PlayerDialogue;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Player;
import model.stats.Stat;
import model.unit.Unit;

public class PlayerViewItem extends ViewItem {
	
	private Player myPlayer;
	private String myImagePath = ICON_PATH+"player_icon.gif";
	
	public PlayerViewItem(Player playa){
		super();
		myPlayer = playa;
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(myImagePath);
	}

	@Override
	public String getListMessage() {
		return "Player";
	}

	@Override
	public void onClick(Controller c) {
	
	}
	
	public void assignUnit(Unit myItem) {
		// Need model method to add unit to player
	}
	
	public Player getPlayer() {
		return myPlayer;
	}

}
