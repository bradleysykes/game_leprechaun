package gae.map;

import gae.viewitems.BoardListViewItem;
import gae.viewitems.NullViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.TileViewItem;
import gae.viewitems.UnitViewItem;
import gae.viewitems.ViewItem;

/**
 * Class used for convenient communication across the Authoring Environment GUI.
 * Used primarily to pass BoardListViewItems and their corresponding PlayerViewItem to the GUIMap for placement.
 * @author Bradley Sykes and William Shelburne
 */

public class BoardBuffer {
	
	private static BoardListViewItem myItem;
	private static PlayerViewItem myPlayer;
	
	
	/**
	 * Method used to retrieve the item currently stored in the buffer. 
	 * Returns a UnitViewItem only if also knows its PlayerViewItem assignment.
	 * @return BoardListViewItem currently stored in the buffer.
	 */
	public static BoardListViewItem retrieve(){
		if(myPlayer!=null&&myItem!=null){
			return myItem;
		}
		if(myPlayer==null&&myItem instanceof UnitViewItem){
			return new NullViewItem();
		}
		if(myPlayer==null&&myItem instanceof TileViewItem){
			return myItem;
		}
		return new NullViewItem();
	}
	
	/**
	 * Method for placing a ViewItem in the buffer for later use.
	 * @param ViewItem item to be stored in the Buffer.
	 */
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
	
	public static boolean hasPlayer(){
		return myPlayer != null;
	}
	
	public static boolean hasPlaceable(){
		return myItem != null;
	}
	
	public static void clear(){
		myItem = null;
	}
}
