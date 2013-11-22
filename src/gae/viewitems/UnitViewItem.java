package gae.viewitems;

import gae.Controller;
import gae.GUIMap;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jgame.JGObject;

import model.GameMap;
import model.Player;
import model.stats.Stat;
import model.unit.Unit;

public class UnitViewItem extends BoardListViewItem {

	private String UNIT_LIST_MESSAGE = "Unit List Message";
	private Unit myUnit;
	private MapObject myMapObject;
	private File myImage;
	
	public UnitViewItem(List<Stat> stats, String name, File imageFile){
		this(name);
		myProperties = stats;
		myImage = imageFile;
		myUnit.setStats(myProperties);
	}
	
	public UnitViewItem(String name) {
		super(name);
		myUnit = new Unit("TEST",new Player(),new GameMap(400, 400));
		myProperties = myUnit.getStats();
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
		return new UnitViewItem(stats, name, imageFile);
	}
	
	public String getImagePath(){
		try {
			return myImage.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getListMessage() {
		return myName;
	}
	@Override
	public Icon getListIcon() {
		if(myImage!=null){
			return new ImageIcon(myImage.getAbsolutePath());
		}
		return new ImageIcon(ICON_PATH+"test_icon_image.png");
	}
	@Override
	public void placeOnBoard(GUIMap map, double x, double y) {
		map.defineImage("unit", "-", 0, getImagePath(),"-");
		//new JGObject(such and such);
		MapObject object = new MapObject(x,y,"unit", this);
	}

}
