package gae;

import java.io.Serializable;

import javax.swing.Icon;

public interface BoardListItem<T extends Serializable>{
	
	/**
	 * Interface for board objects to be properly displayed in game
	 * authoring environment.
	 */
	
	public abstract String getName();
	
	
	public abstract Icon getIcon();

}
