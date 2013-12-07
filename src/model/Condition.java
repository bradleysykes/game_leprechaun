package model;

import model.stats.StatCollection;

public abstract class Condition extends StatCollection {
	
	protected Player myPlayer;

	public Condition(String name, String ID, Player p) {
		super(name, ID);
		myPlayer = p;
	}

	public abstract boolean check();
	
	public Player getPlayer(){
		return myPlayer;
	}

}
