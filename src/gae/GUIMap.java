package gae;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gae.popup_menus.GAEPopupMenu;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.MapObject;
import gae.viewitems.NullViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.TileViewItem;
import gae.viewitems.ViewItem;

import javax.xml.parsers.ParserConfigurationException;

import data.GameElements;
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
	private Map<Point,MapObject> myObjects = new HashMap<Point,MapObject>();
	
	public GUIMap(int width, int height){
		myWidth = width;
		myHeight = height;
		initEngineComponent(TILE_SIZE*myWidth,TILE_SIZE*myHeight);
		myMap = new GameMap(width,height);
	}
	
	public GUIMap(GameElements elements){
		this(elements.getGameMap().getSizeX(),elements.getGameMap().getSizeY());
		myMap = elements.getGameMap();
		Collection<Tile> loadTiles = myMap.getAllTiles();
		Map<Tile,String> tileImages = elements.getTileImageMap();
		Map<Unit,String> unitImages = elements.getUnitImageMap();
		TileViewItem view;
		for(Tile tile:loadTiles){
			view = new TileViewItem();
		}
	}
	
	public void setPopup(GAEPopupMenu popup){
		myPopup = popup;
	}
	
	@Override
	public void removeObjects(String prefix, int cidmask){
		if(prefix==null&&cidmask==0){
			//clear everything
			//it myMap.
			
		}
		else{
			// clear only the objects being removed
		}
		super.removeObjects(prefix, cidmask);
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
	
	public void addObject(MapObject object){
		myObjects.put(object.getPoint(), object);
	}
	

	private int getActualYCoordinate(int coordinate){
		if(0<coordinate&&coordinate<pfHeight()*.125){
			return coordinate;
		}
		if(pfHeight()*.125<=coordinate&&coordinate<=pfHeight()*.375){
			System.out.println(coordinate);
			return 100+(coordinate-100)*4;
		}
		else{
			return 400+coordinate;
	}
}
	
	private int getActualXCoordinate(int coordinate){
		if(0<coordinate&&coordinate<pfWidth()*.125){
			return coordinate;
		}
		if(pfWidth()*.125<=coordinate&&coordinate<=pfWidth()*.375){
			System.out.println(coordinate);
			return 100+(coordinate-100)*4;
		}
		else{
			return 400+coordinate;
		}
	}
	
	private void checkMouse(){
		if(this.getKey(256)&&!(myMap.getTile(tileX/TILE_SIZE, tileY/TILE_SIZE).isOccupied())){
			PlayerViewItem active = BoardBuffer.getActivePlayer();
			BoardListViewItem toPlace = BoardBuffer.retrieve();
			toPlace.clickOnBoard(this, getActualXCoordinate(getMouseX()), getActualYCoordinate(getMouseY()), active);
			System.out.println("Clicked at "+getMouseX()+", "+getMouseY()+".");
			System.out.println("Object placed at "+getActualXCoordinate(getMouseX())+", "+getActualYCoordinate(getMouseY())+".");
			this.revalidate();
			this.clearKey(256);
		}
		if(this.getKey(KeyMouse3)){
			//there is a unit on this tile, right click to display popup menu
			myPopup.show(this,this.getMouseX(),this.getMouseY());
			Point mousePoint = new Point(xOffset,yOffset);
			for(Point p:myObjects.keySet()){
				if(p.equals(mousePoint)){
					
					MapObject selectedObject = myObjects.get(p);
					drawString("Object "+selectedObject.getName()+" selected",viewWidth()*0.25, 10, 0);
					selectedObject.select();
				}
			}
			myPopup.revalidate();
			
		}
	}
	
	public void paintFrame(){
		setColor(JGColor.white);
		setFont(new JGFont("Arial",0,10));
		drawString("Object count = "+this.countObjects(null, 0),viewWidth()*0.25, 10, 0 );
		//drawString("Playfield Size: ("+this.pfWidth()+","+this.pfHeight()+").",viewWidth()/2, 40, 0);
		drawString("Map Dimensions: ("+myWidth+"x"+myHeight+")",viewWidth()*0.75, 10, 0);
		//drawString("Move the mouse to scroll.", viewWidth()/2, 80, 0);
		drawString("Playfield offset is now ("+xOffset+","+yOffset+").",viewWidth()/2, 80, 0);
		drawString("Mouse currently at ("+this.getMouseX()+","+this.getMouseY()+").",viewWidth()/2, 120, 0);
		//drawString("Unit on tile: "+myMap.getTile(tileX/TILE_SIZE, tileY/TILE_SIZE).isOccupied(),viewWidth()/2,160,0);
//		drawString("TOP LEFT",     0,         8,             -1,
//				true // indicate it should be drawn relative to playfield
//			);
//			drawString("BOTTOM LEFT",  0,         -1*pfHeight()-20, -1, true);
//			drawString("TOP RIGHT",    pfWidth(), 8,              1, true);
//			drawString("BOTTOM RIGHT", pfWidth(), -1*pfHeight()-20,  1, true);
	}
	
	public void doFrame(){
		checkMouse();
		tileX = this.getMouseX()-this.getMouseX()%TILE_SIZE;
		tileY = (int)this.getMouseX()-this.getMouseY()%TILE_SIZE;
		unitX = this.getMouseX()-this.getMouseX()%UNIT_SIZE;
		unitY = this.getMouseY()-this.getMouseY()%UNIT_SIZE;
		xOffset =  getMouseX() * pfWidth() / viewWidth();
		yOffset = getMouseY() *pfHeight()/viewHeight();
		this.setViewOffset(xOffset,yOffset, true);
	}
	
	public void fillBoard(ViewItem tile) {
		TileViewItem t = (TileViewItem)tile;
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

	public void loadMapObjects(GameElements elements) {
		GameMap loadMap = elements.getGameMap();
		TileViewItem view;
		for(Tile tile:loadMap.getAllTiles()){
			view = new TileViewItem();
		}
	}

}
