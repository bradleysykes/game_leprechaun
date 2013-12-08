package gae.viewitems;

import gae.Controller;
import gae.GUIMap;
import gae.dialogues.EditDialogue;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {

	private Unit myUnit;
	private String myIDEnding;
	
	public UnitViewItem(List<Stat> stats, String name, File imageFile, int IDcounter){
		super(stats, name, imageFile);
		myUnit = new Unit(name+"|"+IDcounter,new Player(), new Tile(3,3,new GameMap(2,2)));
		myDefaults = myUnit.getStats();
		myUnit.setStats(myProperties);
		myIDEnding = "|"+IDcounter;
	}
	
	/**
	 * use to figure out what properties this type needs
	 */
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}


	@Override
	public void onClick(Controller c) {
		//create on map
	}

//	@Override
//	public BoardListViewItem createModel(List<Stat> stats, String name, File imageFile, int counter) {
//		UnitViewItem item = new UnitViewItem(stats, name, imageFile, counter);
//		myProperties = stats;
//		return item;
//	}
	
	public String getImagePath(){
		try {
			return myImage.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "resources/test_icon_image.png";
		}
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	
	@Override
	public void showProperties(){
		myDialogue = new UnitCreationDialogue(myName,this.getModel(),this);
	}
	
	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		//new JGObject(such and such);
		myMapObject = new MapObject(myMapObjectPrefix, x,y,"unit", this);
	}

	@Override
	public void clickOnBoard(GUIMap map, double x, double y, PlayerViewItem player) {
		map.defineImage(myMapObjectPrefix, "-", 0, "/"+this.getImagePath().replace("\\","/"),"-");
		int tileX = (int)(x-x%TILE_SIZE);
		int tileY = (int)(y-y%TILE_SIZE);
		myMapObject = new MapObject(myMapObjectPrefix,tileX,tileY,myMapObjectPrefix,this);
		map.addObject(myMapObject, this);
		GameMap modelMap = map.getModelMap();
		Tile selectedTile = modelMap.getTile(tileX/TILE_SIZE, tileY/TILE_SIZE);
		Unit newGuy = new Unit(myName+myIDEnding, player.getPlayer(), selectedTile);
		selectedTile.addUnit(newGuy);
		newGuy.setCurrentTile(selectedTile);
		player.assignUnit(newGuy);
	}

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
		return "z"+myName+hashCode();
	}

	@Override
	public Unit getModelObject() {
		return myUnit;
	}
	
}
