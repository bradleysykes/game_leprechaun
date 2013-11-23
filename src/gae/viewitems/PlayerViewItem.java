package gae.viewitems;

import gae.Controller;
import gae.dialogues.PlayerDialogue;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Player;
import model.stats.Stat;

public class PlayerViewItem extends ViewItem {
	
	private Player myPlayer;
	private String myImagePath = ICON_PATH+"player_icon.gif";
	
	public PlayerViewItem(Player playa){
		super();
		myPlayer = playa;
	}
	@Override
	public Icon getListIcon() {
		System.out.println(myImagePath);
		return new ImageIcon(myImagePath);
	}

	@Override
	public String getListMessage() {
		// TODO Auto-generated method stub
		return "Player";
	}

	@Override
	public void onClick(Controller c) {
		//PlayerDialogue d = new PlayerDialogue();
	}

}
