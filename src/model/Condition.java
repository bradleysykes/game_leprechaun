package model;

import model.things.StatCollection;

public abstract class Condition extends StatCollection {

	public Condition(String name) {
		super(name);
	}

	public abstract boolean check();

}
