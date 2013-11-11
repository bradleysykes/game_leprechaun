package gae;

import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.JList;

public interface BoardListItem<T extends Serializable>{
	
	/**
	 * Interface for board objects to be properly displayed in game
	 * authoring environment.
	 */
	
	public abstract String getName();
	
	
	public abstract Icon getIcon();
	
	public abstract Class getObjectClass();
	
	public abstract void onSelected(UnitList listSource);

}
