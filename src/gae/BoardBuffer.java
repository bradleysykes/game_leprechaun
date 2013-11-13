package gae;

import gae.viewitems.ViewItem;

import java.awt.Component;

public class BoardBuffer {
	
	private static ViewItem myItem;
	
	
	public static ViewItem retrieve(){
		return myItem;
	}
	
	public static void push(ViewItem item){
		myItem = item;
	}
}
