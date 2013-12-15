package gae.viewitems;

import java.io.File;
import java.util.List;

import gae.map.GUIMap;
import gae.map.XCoordinate;
import gae.map.YCoordinate;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.ImageTool;

import model.GameMap;
import model.stats.Stat;
import model.stats.StatCollection;
import model.tile.Tile;

public class TileViewItem extends BoardListViewItem {

	private Tile myTile;
	
	public TileViewItem(){
		this(new Tile(20,20,new GameMap(20,20)).getStats(),DEFAULT_TILE_NAME,new File(DEFAULT_TILE_PATH), 0);
	}
	
	public TileViewItem(List<Stat> stats,String name, File f, int counter){
		super(stats, name, f);
		myTile = new Tile(20,20,new GameMap(20,20));
		myTile.setStats(stats);
		myIDEnding = "|"+counter;
		myTile.setID(name+myIDEnding);
		myTile.getStatCollection("Terrain").setID(name);
	}
	
	public TileViewItem(Tile tile, File imageFile){
		super(tile.getStats(), tile.getID(),imageFile);
		myTile = tile;
		myIDEnding = tile.getID().split("\\|")[1];
	}
	
	public TileViewItem(StatCollection modelObject, File imageFile){
			this((Tile)modelObject,imageFile);
	}

	@Override
	public void placeOnBoard(GUIMap map, int x, int y) {
		//new JGObject(such and such);
		map.defineImage(myMapObjectPrefix, "-", 0, "/"+this.getImagePath().replace("\\","/"),"-");
		myMapObject = new MapObject(myMapObjectPrefix,x*TILE_SIZE,y*TILE_SIZE,myMapObjectPrefix, this);
		Tile tile = new Tile((int) x,(int) y, myTile);
		String uniqueTileID = myTile.getID();
		tile.setID(uniqueTileID);
		map.getModelMap().setTile((int)x, (int)y, tile);
		map.addObject(this.getMapObject());
		
	}
	
	@Override
    public void clickOnBoard(GUIMap map, double x, double y, PlayerViewItem player){
            int xTile = (int) ((x-x%TILE_SIZE)/TILE_SIZE);
            int yTile = (int) ((y-y%TILE_SIZE)/TILE_SIZE);
            map.defineImage(myMapObjectPrefix, "-", 0, "/"+this.getImagePath().replace("\\","/"),"-");
            myMapObject = new TileMapObject(myMapObjectPrefix,x-x%TILE_SIZE,y-y%TILE_SIZE,myMapObjectPrefix,this);
            this.updateModel(xTile,yTile,map);
    }
    
	/**
	 * Method to update model to reflect changes in view.
	 * @param int x: Tile location
	 * @param int y: Tile location
	 * @param GUIMap map: Current game map.
	 */
	private void updateModel(int x, int y, GUIMap map){
		Tile tile = new Tile(x,y, myTile);
		tile.getStatCollection("Terrain").setID(myTile.getStatCollection("Terrain").getID());
		tile.setID(myTile.getID());
		map.getModelMap().setTile(x, y, tile);
		map.addObject(this.getMapObject());
	}
	
	/**Getters and setters**/
	
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
	
	public Tile getModelObject() {
		return myTile;
	}
	
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	
	public String getImagePath(){
		if(myImage!=null){
			return myImagePath;
		}
		return DEFAULT_TILE_PATH;
	}
}
