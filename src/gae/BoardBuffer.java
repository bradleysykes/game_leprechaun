package gae;

import java.awt.Component;

public class BoardBuffer {
	
	private static BoardListItem myItem;
	
	
	public static BoardListItem retrieve(){
		System.out.println("retrieve");
		return myItem;
	}
	
	public static void push(BoardListItem item){
		myItem = item;
	}
}
