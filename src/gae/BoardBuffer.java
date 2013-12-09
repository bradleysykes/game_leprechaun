package gae;

import gae.dialogues.UnitAlert;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.TileViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Player;

public class BoardBuffer {
	
	private static BoardListViewItem myItem;
	private static PlayerViewItem myPlayer;
	
	
	public static BoardListViewItem retrieve(){
		if(myPlayer!=null&&myItem!=null){
			return myItem;
		}
		if(myPlayer==null&&myItem instanceof UnitViewItem){
			//requires units to be assigned player before placement
//			JOptionPane alertPane = new JOptionPane("Please select a unit and a player before placing on map.");
//			JDialog dialog = alertPane.createDialog(null,"Player alert");
//			dialog.setLocation(10, 10);
//			//dialog.setVisible(true);
			return new NullViewItem();
		}
		if(myPlayer==null&&myItem instanceof TileViewItem){
			//allows user to place tile without assigning player
			return myItem;
		}
		return new NullViewItem();
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
