package gae.viewitems;

import gae.Controller;
import gae.GUIMap;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.ImageTool;

import jgame.JGObject;

import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {

	private String UNIT_LIST_MESSAGE = "Unit List Message";
	private Unit myUnit = new Unit("Unit",new Player(), new GameMap(50,50));
	private MapObject myMapObject;
	private File myImage;
	private String myImagePath;
	
	public UnitViewItem(List<Stat> stats, String name, File imageFile){
		super(name);
		myProperties = stats;
		if(!(imageFile==null)){
			//image file has been uploaded by user
			myImagePath = imageFile.getPath();
			myImage = imageFile;
			System.out.println(myImage.getPath());
			ImageTool.scaleAndOverwriteImage(myImage.getPath(), 79, 79);
		}
		else{
			//default image file
			myImagePath=System.getProperty("user.dir")+"\\src\\gae\\resources\\test_icon_image.png";
			myImage = new File(myImagePath);
			ImageTool.scaleAndOverwriteImage(myImage.getPath(), 79,79);
		}
		myUnit.setStats(myProperties);
	}
	
	public UnitViewItem(String name) {
		this(new Unit("Unit",new Player(), new GameMap(50,50)).getStats(),name,new File(System.getProperty("user.dir")+"\\src\\gae\\resources\\test_icon_image.png"));
//		super(name);
//		myUnit = new Unit("TEST",new Player(),new GameMap(400, 400));
//		myProperties = myUnit.getStats();
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
	public Icon getListIcon() {
		return new ImageIcon(myImage.getPath());
	}
	
	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		//new JGObject(such and such);
		MapObject object = new MapObject(x,y,"unit", this);
	}

	@Override
	public void clickOnBoard(GUIMap map, double x, double y) {
		map.defineImage("unit", "-", 0, "/"+this.getImagePath().replace("\\","/"),"-");
		System.out.println(x + "   " +y);
		myMapObject = new MapObject(x-x%UNIT_SIZE,y-y%UNIT_SIZE,"unit",this);
	}

}
