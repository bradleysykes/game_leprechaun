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
	private int myNumber;
	
	public PlayerViewItem(Player playa, int playerNumber){
		super();
		myPlayer = playa;
		myNumber = playerNumber;
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(myImagePath);
	}

	@Override
	public String getListMessage() {
		return "Player "+myNumber;
	}

	@Override
	public void onClick(Controller c) {
	
	}
	
	public void assignUnit(Unit myItem) {
		myPlayer.addUnit(myItem);
	}
	
	public Player getPlayer() {
		return myPlayer;
	}

}
