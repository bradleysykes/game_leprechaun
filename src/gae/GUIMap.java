package gae;

import gae.viewitems.ViewItem;

import javax.xml.parsers.ParserConfigurationException;

import data.encoder.MapEncoder;
import util.reflection.Reflection;
import model.GameMap;
import model.tile.Tile;
import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class GUIMap extends JGEngine {
	
	private MapEncoder myEncoder;
	private int myWidth;
	private int myHeight;
	private GameMap myMap;

	public GUIMap(int width, int height){
		initEngineComponent(500,500);
		myMap = new GameMap(width,height);
		myWidth = width;
		myHeight = height;
		try {
			myEncoder = new MapEncoder(width,height);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, myWidth, myHeight, JGColor.blue, JGColor.blue, null);
	}
	
	public void placeOnBoard(){
		if(this.getKey(256)&&BoardBuffer.retrieve()!=null){
			BoardBuffer.retrieve().placeOnBoard(this, (double) this.getMouseX(), (double) this.getMouseY());
		}
	}
	
	public void doFrame(){
		placeOnBoard();
	}

	@Override
	public void initGame() {
		setFrameRate(40, 1);
		setPFSize(1,1);
	}


	public void setDefaultTiles() {
		GameMap map = new GameMap(this.getWidth(),this.getHeight());
		for(int q=0;q<this.pfHeight();q+=20){
			for(int m = 0;m<this.pfWidth();m+=20){
//				System.out.println("Tile placed");
//				Tile t = new Tile();
//				myEncoder.addXmlElement(t);
			}
		}
	}

}
