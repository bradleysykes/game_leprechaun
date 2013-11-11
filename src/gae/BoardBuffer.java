package gae;

import java.awt.Component;

public class BoardBuffer {
	
	private static BoardListItem myItem;
	
	
	public static BoardListItem retrieve(){
		System.out.println("retrive");
		return myItem;
	}
	
	public static void push(BoardListItem item){
		myItem = item;
	}
}
