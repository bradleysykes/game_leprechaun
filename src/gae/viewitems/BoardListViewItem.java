package gae.viewitems;

import gae.dialogues.EditDialogue;
import gae.dialogues.InputDialogue;
import gae.map.GUIMap;
import gae.map.XCoordinate;
import gae.map.YCoordinate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import util.ImageTool;
import model.stats.Stat;

/**
 * Abstract superclass serving as a frontend representation of model objects that can be added to the Game.
 * Subclass to create new object that the user can add to the Map.
 * Extends ViewItem.
 * @author Bradley
 * @param <T> Generic type to represent the model object stored in the subclass.
 */

public abstract class BoardListViewItem<T> extends ViewItem {
	
	protected List<Stat> myProperties = new ArrayList<Stat>();
	protected List<Stat> myDefaults;
	protected String myName;
	protected MapObject myMapObject;
	protected String myMapObjectPrefix;
	protected File myImage;
	protected String myImagePath;
	protected InputDialogue myDialogue;
	protected String myIDEnding;
	
	/**
	 * Constructor for creating a new BoardListViewItem from a model's stats, a custom name, and an image.
	 * @param List<Stat> stats: All of the stats defined by this view item's model object.
	 * @param String name: The custom name assigned to this type.
	 * @param File imageFile: The image file assigned to this type. Used for displaying on map.
	 */
	public BoardListViewItem(List<Stat> stats, String name, File imageFile){
		myName = name;
		myProperties = stats;
		myMapObjectPrefix = getMapPrefix();
		this.processImage(imageFile);
	}
	
	/**
	 * Special constructor used for a condition. 
	 * For use if type will never be visually displayed on the map.
	 * @param String name: Custom name for this type.
	 */
	protected BoardListViewItem(String name){
		myName = name;
	}
	
	/**
	 * Method for placing an instance of this specific type in a procedural way. 
	 * @param GUIMap map: Map object onto which an instance of this type will be placed.
	 * @param double x: Location of instance.
	 * @param double y: Location of instance.
	 */
	public void placeOnBoard(GUIMap map, int x, int y){
		// default is to do nothing.
	}
	
	/**
	 * Method for placing an instance of this type in response to a user click.
	 * @param GUIMap map: Map object onto which an instance of this type will be placed.
	 * @param double x: Location of instance.
	 * @param double y: Location of instance.
	 * @param PlayerViewItem activePlayer: Player assignment for this item.
	 */
	public void clickOnBoard(GUIMap map, double x, double y, PlayerViewItem activePlayer){
		// default is to do nothing.
	}
	
	/**
	 * Method to get this type's model object.
	 * @return T The specific model object belonging to the subclass. 
	 */
	public abstract T getModelObject();
	
	/**
	 * @return String unique map prefix used for creating MapObjects.
	 */
	protected abstract String getMapPrefix();
	
	protected abstract int getResizeDimensions();

	protected abstract String getDefaultImagePath();

	public abstract List<Stat> getModel();
	
	/**
	 * Method used to check if user uploaded an image for this type.
	 * Assigned a default image if no image uploaded.
	 * Resizes image appropriately.
	 * @param File imageFile: This game type's image.
	 */
	private void processImage(File imageFile){
		int resizeDimensions = this.getResizeDimensions();
		if(!(imageFile==null)){
			//image file has been uploaded by user
			myImagePath = imageFile.getPath();
			myImage = imageFile;
			ImageTool.scaleAndOverwriteImage(myImage.getPath(), resizeDimensions,resizeDimensions);
		}
		else{
			//default image file
			myImagePath=getDefaultImagePath();
			myImage = new File(myImagePath);
			ImageTool.scaleAndOverwriteImage(myImage.getPath(), resizeDimensions,resizeDimensions);
		}
	}

	/**
	 * Method used to edit an existing game type.
	 */
	@Override
	public void launchEdit(){
		myDialogue = new EditDialogue(myName,this.getModel(),myListSource, new NullViewItem());
	}
	
	/**
	 * Getters/Setters
	 */
	
	@Override
	public int hashCode(){
		return (int)System.currentTimeMillis();
	}
	
	public String getPrefix(){
		return myMapObjectPrefix;
	}
	
	@Override
	public Icon getListIcon(){
		return new ImageIcon(myImagePath);
	}


	public void setName(String name) {
		myName = name;		
	}
	
	public String getName(){
		return myName;
	}
	
	public MapObject getMapObject() {
		return myMapObject;
	}

	public boolean onMap() {
		return myMapObject != null;
	}
	
	@Override
	public boolean dialogueActive(){
		return false;
	}

}
