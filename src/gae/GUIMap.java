package gae;

import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.NullViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.TileViewItem;
import gae.viewitems.ViewItem;

import javax.xml.parsers.ParserConfigurationException;

import data.encoder.MapEncoder;
import util.reflection.Reflection;
import model.GameMap;
import model.Player;
import model.tile.Tile;
import jgame.JGColor;
import jgame.JGFont;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class GUIMap extends JGEngine implements Constants{
	
	private MapEncoder myEncoder;
	private int myWidth;
	private int myHeight;
	private GameMap myMap;
	private GAEPopupMenu myPopup;
	private int xOffset = 0, yOffset=0;
	private int tileX = 0, tileY = 0;
	private int unitX = 0, unitY=0;
	
	public GUIMap(int width, int height, int componentWidth, int componentHeight){
		myWidth = width;
		myHeight = height;
		initEngineComponent(TILE_SIZE*myWidth,TILE_SIZE*myHeight);
		myMap = new GameMap(width,height);
	}
	
	public void setPopup(GAEPopupMenu popup){
		myPopup = popup;
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, (TILE_SIZE*myWidth)/2, (TILE_SIZE*myHeight)/2, null,null, null);
	}
	
	@Override
	public void initGame() {
		setFrameRate(45, 2);
		setPFSize(2,2);
	}
	
	public void checkMouse(){
		if(this.getKey(256)&&myMap.getTile(x, y)){
			PlayerViewItem active = BoardBuffer.getActivePlayer();
			BoardBuffer.retrieve().clickOnBoard(this, (double) xOffset, (double) yOffset, active);
			this.revalidate();
		}
		if(this.getKey(KeyMouse3)&&myPopup!=null){
			myPopup.show(this,this.getMouseX(),this.getMouseY());
			myPopup.revalidate();
		}
	}
	
	public void paintFrame(){
		setColor(JGColor.white);
		setFont(new JGFont("Arial",0,20));
		drawString("Objects on board = "+this.countObjects(null, 0),viewWidth()/2, 40, 0 );
		//drawString("Playfield Size: ("+this.pfWidth()+","+this.pfHeight()+").",viewWidth()/2, 40, 0);
		drawString("View Dimensions: ("+this.viewWidth()+","+this.viewHeight()+").",viewWidth()/2, 10, 0);
		//drawString("Move the mouse to scroll.", viewWidth()/2, 80, 0);
		drawString("Playfield offset is now ("+xOffset+","+yOffset+").",viewWidth()/2, 80, 0);
		drawString("Mouse currently at ("+this.getMouseX()+","+this.getMouseY()+").",viewWidth()/2, 120, 0);
//		drawString("TOP LEFT",     0,         8,             -1,
//				true // indicate it should be drawn relative to playfield
//			);
//			drawString("BOTTOM LEFT",  0,         -1*pfHeight()-20, -1, true);
//			drawString("TOP RIGHT",    pfWidth(), 8,              1, true);
//			drawString("BOTTOM RIGHT", pfWidth(), -1*pfHeight()-20,  1, true);
	}
	
	public void doFrame(){
		checkMouse();
		this.clearKey(256);
		tileX = this.getMouseX()-this.getMouseX()%TILE_SIZE;
		tileY = (int)this.getMouseX()-this.getMouseY()%TILE_SIZE;
		unitX =
		unitY = 
		xOffset =  getMouseX() * pfWidth() / viewWidth();
		yOffset = (getMouseY() *pfHeight()/viewHeight());
		this.setViewOffset(xOffset,yOffset, true);
	}
	
	public void fillBoard(ViewItem tile) {
		TileViewItem t = (TileViewItem)tile;
		System.out.println(myWidth);
		System.out.println(myHeight);
		this.defineImage("tile", "-", 0, "/"+t.getImagePath(),"-");
		for(int q=0;q<myWidth;q+=1){
			for(int m = 0;m<myHeight;m+=1){
				t.placeOnBoard(this, q, m);
			}
		}
	}

	public GameMap getModelMap() {
		return myMap;
	}

}
