package gae;

import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

import java.awt.Component;

import model.Player;

public class BoardBuffer {
	
	private static BoardListViewItem myItem;
	private static PlayerViewItem myPlayer;
	
	
	public static BoardListViewItem retrieve(){
		if(myPlayer!=null){
			return myItem;
		}
		else{
			System.out.println("Please select a player");
			return new NullViewItem();
		}
	}
	
	public static void clear(){
		myItem = null;
	}
	
	public static void push(ViewItem item){
		if(item instanceof BoardListViewItem){
			myItem = (BoardListViewItem)item;
		}
		if(item instanceof PlayerViewItem){
			myPlayer = (PlayerViewItem)item;
		}
	}

	public static PlayerViewItem getActivePlayer() {
		return myPlayer;
	}
}
