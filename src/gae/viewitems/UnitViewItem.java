package gae.viewitems;

import gae.Controller;
import gae.GUIMap;
import gae.dialogues.EditDialogue;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {

	private Unit myUnit = new Unit("Unit",new Player(), new GameMap(50,50));
	private InputDialogue myDialogue;
	
	public UnitViewItem(List<Stat> stats, String name, File imageFile){
		super(stats, name, imageFile);
		myUnit.setStats(myProperties);
	}
	
	public UnitViewItem(String name) {
		this(new Unit("Unit",new Player(), new GameMap(50,50)).getStats(),name,new File(System.getProperty("user.dir")+"\\src\\gae\\resources\\test_icon_image.png"));
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

	@Override
	public BoardListViewItem createModel(List<Stat> stats, String name, 
			File imageFile) {
		UnitViewItem item = new UnitViewItem(stats, name, imageFile);
		return item;
	}
	
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
		int tileX = (int)(x-x%UNIT_SIZE);
		int tileY = (int)(y-y%UNIT_SIZE);
		myMapObject = new MapObject(myMapObjectPrefix,tileX,tileY,myMapObjectPrefix,this);
		GameMap modelMap = map.getModelMap();
		Unit newGuy = new Unit(myName, player.getPlayer(), modelMap);
		Tile selectedTile = modelMap.getTile(tileX/TILE_SIZE, tileY/TILE_SIZE);
		selectedTile.addUnit(newGuy);
		newGuy.setMapPosition(tileX/UNIT_SIZE,tileY/UNIT_SIZE);
		player.assignUnit(newGuy);
	}
	
	@Override
	public void launchEdit(){
		myDialogue = new EditDialogue(myName,this.getModel(),this);
	}

	@Override
	protected String getDefaultImagePath() {
		return DEFAULT_UNIT_PATH;
	}

	@Override
	protected int getResizeDimensions() {
		return UNIT_IMAGE_RESIZE;
	}

}
