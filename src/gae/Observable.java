package gae;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
	
	List<Observer> myObservers = new ArrayList<Observer>();
	
	public abstract void register(Observer observer);
	
	public abstract void unregister();
	
	public abstract void notifyObservers();
	
	public abstract void getUpdate();
	
	public abstract void execute(Object o);
}
