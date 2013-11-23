package gae.viewitems;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gae.Constants;
import gae.GUIMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.ImageTool;

import model.GameMap;
import model.stats.Stat;
import model.tile.Tile;

public class TileViewItem extends BoardListViewItem {

	private Tile myTile = new Tile(20,20,new GameMap(20,20));
	private MapObject myMapObject;
	private File myImage;
	private String myImagePath;
	
	public TileViewItem(){
		this(new Tile(20,20,new GameMap(20,20)).getStats(),"Default",new File(System.getProperty("user.dir")+"\\src\\gae\\resources\\test_tile.jpg"));
	}
	
	public TileViewItem(List<Stat> stats,String name, File f){
		super(name);
		myProperties = stats;
		if(!(f==null)){
			myImagePath = f.getPath();
			myImage = f;
			ImageTool.scaleAndOverwriteImage(myImage.getPath(), 79, 79);
		}
		else{
			myImagePath=System.getProperty("user.dir")+"\\src\\gae\\resources\\test_tile.jpg";
			myImage = new File(myImagePath);
			ImageTool.scaleAndOverwriteImage(myImage.getPath(), 79,79);
		}
	}
	
	@Override
	public List<Stat> getModel() {
		return myProperties;
	}

	@Override
	public BoardListViewItem createModel(List<Stat> inputData, String name, File imageFile) {
		//newGuy.setStats(inputData);
		BoardListViewItem newGuy = new TileViewItem(inputData,name,imageFile);
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

	/**
	 * icon used to display viewitem in its list
	 */
	@Override
	public Icon getListIcon() {
		return new ImageIcon(myImage.getPath());
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
		myMapObject = new MapObject(x*TILE_SIZE,y*TILE_SIZE,"tile", this);
		//System.out.println("tile placed");
	}
	@Override
	public void clickOnBoard(GUIMap map, double x, double y){
		map.defineImage("tile", "-", 0, "/"+this.getImagePath().replace("\\","/"),"-");
		System.out.println(x + "   " +y);
		myMapObject = new MapObject(x-x%TILE_SIZE,y-y%TILE_SIZE,"tile",this);
	}
	
}
