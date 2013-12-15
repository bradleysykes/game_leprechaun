package gae.viewitems;

import gae.control.Controller;
import gae.dialogues.UnitCreationDialogue;
import gae.map.GUIMap;
import java.io.File;
import java.io.IOException;
import java.util.List;
import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {

	private Unit myUnit;
	
	public UnitViewItem(List<Stat> stats, String name, File imageFile, int IDcounter){
		super(stats, name, imageFile);
		myUnit = new Unit(name+"|"+IDcounter,new Player(), new Tile(3,3,new GameMap(2,2)));
		myDefaults = myUnit.getStats();
		myUnit.setStats(myProperties);
		myIDEnding = "|"+IDcounter;
	}
	
	public UnitViewItem(Unit unit, File imageFile){
		super(unit.getStats(), unit.getID(), imageFile);
		myUnit = unit;
		myDefaults = myUnit.getStats();
		myIDEnding = unit.getID().split("\\|")[1];
	}

	 
	@Override
    public void clickOnBoard(GUIMap map, double x, double y, PlayerViewItem player) {
	     map.defineImage(myMapObjectPrefix, "-", 0, "/"+this.getImagePath().replace("\\","/"),"-");
	     int tileX = (int)(x-x%TILE_SIZE);
	     int tileY = (int)(y-y%TILE_SIZE);
	     myMapObject = new MapObject(myMapObjectPrefix,tileX,tileY,myMapObjectPrefix,this);
	     map.addObject(myMapObject);
	     this.updateModel(map,tileX,tileY,player);
     }
	
	private void updateModel(GUIMap map, int tileX, int tileY, PlayerViewItem player){
		GameMap modelMap = map.getModelMap();
        Tile selectedTile = modelMap.getTile(tileX/TILE_SIZE, tileY/TILE_SIZE);
        Unit newGuy = new Unit(myUnit, player.getPlayer(), selectedTile);
        selectedTile.addUnit(newGuy);
        newGuy.setCurrentTile(selectedTile);
        player.assignUnit(newGuy);
	}
	
	@Override
	public void showProperties(){
		myDialogue = new UnitCreationDialogue(myName,this.getModel(),this);
	}
	
	/**Getters and Setters**/

	@Override
	protected String getDefaultImagePath() {
		return DEFAULT_UNIT_PATH;
	}

	@Override
	protected int getResizeDimensions() {
		return UNIT_IMAGE_RESIZE;
	}

	@Override
	protected String getMapPrefix() {
		return UNIT_MAP_PREFIX+myName+hashCode();
	}

	@Override
	public Unit getModelObject() {
		return myUnit;
	}
	
	/**
	 * use to figure out what properties this type needs
	 */
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}
	
	public String getImagePath(){
		try {
			return myImage.getCanonicalPath();
		} catch (IOException e) {
			return DEFAULT_UNIT_PATH;
		}
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	
}
