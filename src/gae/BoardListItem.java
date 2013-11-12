package gae;

public interface BoardListItem{
	
	
	/**
	 * Interface for board objects to be properly displayed in game
	 * authoring environment.
	 */
	public abstract String getRelativeImagePath();
	
	public abstract String getImagePath();
	
	public abstract String getObjectClass();

}
