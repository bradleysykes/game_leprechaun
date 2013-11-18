package model;

import model.stats.StatCollection;

public abstract class Condition extends StatCollection {
	protected Player myPlayer;

	public Condition(String name, Player p) {
		super(name);
		myPlayer = p;
	}

	public abstract boolean check();

}
