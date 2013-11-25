package gae.viewitems;

import java.io.File;
import java.util.List;
import gae.GUIMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.ImageTool;

import model.GameMap;
import model.stats.Stat;
import model.tile.Tile;

public class TileViewItem extends BoardListViewItem {

	private Tile myTile;
	private String myIDEnding;
	
	public TileViewItem(){
		this(new Tile(20,20,new GameMap(20,20)).getStats(),"Default",new File(DEFAULT_TILE_PATH), 0);
	}
	
	public TileViewItem(List<Stat> stats,String name, File f, int counter){
		super(stats, name, f);
		myTile = new Tile(20,20,new GameMap(20,20));
		myIDEnding = "|"+counter;
	}
	
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public BoardListViewItem createModel(List<Stat> inputData, String name, File imageFile, int counter) {
		//newGuy.setStats(inputData);
		BoardListViewItem newGuy = new TileViewItem(inputData,name,imageFile, counter);
		return newGuy;
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	
	public String getImagePath(){
		if(myImage!=null){
			return myImagePath;
		}
		return "resources/test_tile.jpg";
	}

	public int getImageHeight(){
		return 0;
	}
	public int getImageWidth(){
		return 0;
	}

	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		//new JGObject(such and such);
		myMapObject = new MapObject(myMapObjectPrefix,x*TILE_SIZE,y*TILE_SIZE,"tile", this);
	}
	@Override
	public void clickOnBoard(GUIMap map, double x, double y, PlayerViewItem player){
		int xTile = (int) ((x-x%TILE_SIZE)/TILE_SIZE);
		int yTile = (int) ((y-y%TILE_SIZE)/TILE_SIZE);
		map.defineImage(myMapObjectPrefix, "-", 0, "/"+this.getImagePath().replace("\\","/"),"-");
		myMapObject = new TileMapObject(myMapObjectPrefix,x-x%TILE_SIZE,y-y%TILE_SIZE,myMapObjectPrefix,this);
		map.getModelMap().setTile(xTile, yTile, myTile);
	}
	
	@Override
	protected String getDefaultImagePath() {
		return DEFAULT_TILE_PATH;
	}

	@Override
	protected int getResizeDimensions() {
		return TILE_IMAGE_RESIZE;
	}

	@Override
	protected String getMapPrefix() {
		return "a"+myName+this.hashCode();
	}

	@Override
	public List<Stat> getDefaults() {
		return myDefaults;
	}
	
	public Object getModelObject() {
		return myTile;
	}
	
}
