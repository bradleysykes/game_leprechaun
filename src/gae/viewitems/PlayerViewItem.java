package gae.viewitems;

import gae.dialogues.PlayerDialogue;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Player;
import model.things.Thing;

public class PlayerViewItem extends ViewItem {
	
	private Player myPlayer;
	
	public PlayerViewItem(Player playa){
		super();
		myPlayer = playa;
	}
	@Override
	public Icon getListIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(ICON_PATH+"player_icon.gif");
	}

	@Override
	public String getListMessage() {
		// TODO Auto-generated method stub
		return "Player";
	}

	@Override
	public List<Thing> getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onClick() {
		PlayerDialogue d = new PlayerDialogue();
	}

}
