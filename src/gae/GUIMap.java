package gae;

import gae.viewitems.TileViewItem;
import gae.viewitems.ViewItem;

import javax.xml.parsers.ParserConfigurationException;

import data.encoder.MapEncoder;
import util.reflection.Reflection;
import model.GameMap;
import model.tile.Tile;
import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class GUIMap extends JGEngine implements Constants{
	
	private MapEncoder myEncoder;
	private int myWidth;
	private int myHeight;
	private GameMap myMap;

	public GUIMap(int width, int height, int componentWidth, int componentHeight){
		myWidth = width;
		myHeight = height;
		//System.out.println(componentWidth + " " + componentHeight);
		initEngineComponent(TILE_SIZE*myWidth,TILE_SIZE*myHeight);
		//myMap = new GameMap(width,height);
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, TILE_SIZE*myWidth, TILE_SIZE*myHeight, null,null, null);
	}
	
	public void placeOnBoard(){
		if(this.getKey(256)&&BoardBuffer.retrieve()!=null){
			BoardBuffer.retrieve().clickOnBoard(this, (double) this.getMouseX(), (double) this.getMouseY());
		}
	}
	
	public void doFrame(){
		if (getMouseButton(1)) {
			clearMouseButton(1);
			System.out.println("Mouse at: "+ this.getMouseX() + ","+this.getMouseY());
			
			//System.out.println(this.countObjects("turtle", 50));
			//onClickAction();
		}
		placeOnBoard();
		//System.out.println(this.getMouseX()+" "+this.getMouseY());
		//this.drawString("Test",this.getMouseX(),this.getMouseY(),0);
		//this.setViewOffset(this.getWidth()/2-this.getMouseX(), this.getHeight()/2-this.getMouseX(), true);
	}

	@Override
	public void initGame() {
		setFrameRate(40, 1);
		//setPFSize(myWidth*TILE_SIZE,myWidth*TILE_SIZE);
	}


	public void fillBoard(ViewItem tile) {
		TileViewItem t = (TileViewItem)tile;
		System.out.println(myWidth);
		System.out.println(myHeight);
		
		for(int q=0;q<myWidth;q+=1){
			for(int m = 0;m<myHeight;m+=1){
				t.placeOnBoard(this, q, m);
			}
		}
	}

}
