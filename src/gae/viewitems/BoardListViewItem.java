package gae.viewitems;

import gae.Controller;
import gae.GUIMap;
import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.ImageTool;

import jgame.JGObject;

import model.stats.Stat;

public abstract class BoardListViewItem extends ViewItem {
	protected List<Stat> myProperties = new ArrayList<Stat>();
	protected String myName;
	protected MapObject myMapObject;
	protected String myMapObjectPrefix;
	protected File myImage;
	protected String myImagePath;
	
	public BoardListViewItem(List<Stat> stats, String name, File imageFile){
		myName = name;
		myProperties = stats;
		myMapObjectPrefix = getMapPrefix();
		int resizeDimensions = getResizeDimensions();
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
	
	protected abstract String getMapPrefix();

	protected BoardListViewItem(String name){
		//special constructor for a Condition
		myName = name;
	}
	
	protected abstract int getResizeDimensions();

	protected abstract String getDefaultImagePath();

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

	@Override
	public abstract String getListMessage();

	public abstract List<Stat> getModel();
	
	public abstract void placeOnBoard(GUIMap map, double x, double y);
	
	public abstract void clickOnBoard(GUIMap map, double x, double y, PlayerViewItem activePlayer);
	 

	@Override
	public void onClick(Controller c) {
		// TODO Auto-generated method stub
		
	}

	public abstract BoardListViewItem createModel(List<Stat> inputData, String name, File imageFile);
	
	public JGObject getMapObject() {
		return myMapObject;
	}

}
