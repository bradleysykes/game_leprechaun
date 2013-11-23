package gae;

import gae.viewitems.BoardListViewItem;
import gae.viewitems.ViewItem;

import java.awt.Component;

public class BoardBuffer {
	
	private static BoardListViewItem myItem;
	
	
	public static BoardListViewItem retrieve(){
		return myItem;
	}
	
	public static void clear(){
		myItem = null;
	}
	
	public static void push(ViewItem item){
		if(item instanceof BoardListViewItem){
			myItem = (BoardListViewItem)item;
		}
	}
}
