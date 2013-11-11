package gae;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JList;

public interface BoardListItem<T extends Serializable>{
	
	public List<PropertyChangeListener> myListeners = new ArrayList<PropertyChangeListener>();
	
	/**
	 * Interface for board objects to be properly displayed in game
	 * authoring environment.
	 */
	public abstract String getRelativeImagePath();
	
	public abstract void notifyListeners(Object object, String property, String oldValue, String newValue);
	
	public void addChangeListener(PropertyChangeListener newListener);
	
	public abstract String getName();
	
	public abstract Icon getIcon();
	
	public abstract String getImagePath();
	
	public abstract Class getObjectClass();
	
	public abstract void onSelected(BoardList listSource);

}
