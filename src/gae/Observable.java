package gae;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
	
	List<Observer> myObservers = new ArrayList<Observer>();
	
	public abstract void register();
	
	public abstract void unregister();
	
	public abstract void notifyObservers();
	
	public abstract void getUpdate();
}
