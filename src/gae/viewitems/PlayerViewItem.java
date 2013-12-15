package gae.viewitems;


import gae.dialogues.EditPlayerDialogue;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Player;
import model.unit.Unit;

public class PlayerViewItem extends ViewItem {
	
	private Player myPlayer;
	private int myNumber;
	private String myName;
	
	public PlayerViewItem(Player player, int playerNumber){

		myPlayer = player;
		myNumber = playerNumber;
		myName = PLAYER_NAME_PREFIX+myNumber;
	}
	public PlayerViewItem(Player playa){
		myPlayer = playa;
		myNumber = 0;
		myName = playa.getID();
	}
	@Override
	public Icon getListIcon() {
		return new ImageIcon(PLAYER_ICON_PATH);
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	
	@Override
	public void launchEdit(){
		EditPlayerDialogue myDialogue = new EditPlayerDialogue(myPlayer, this, myListSource);
	}
	
	public void assignUnit(Unit myItem) {
		myPlayer.addUnit(myItem);
	}
	
	public Player getPlayer() {
		return myPlayer;
	}
	public void setName(String name) {
		myName = name;
	}
	@Override
	public boolean dialogueActive() {
		return false;
	}
}
