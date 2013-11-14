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

	public GUIMap(){
		initEngineComponent(500,500);
		try {
			myEncoder = new MapEncoder(500,500);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, displayWidth(), displayHeight(), JGColor.blue, JGColor.blue, null);
	}
	
	public void placeOnBoard(){
		if(this.getKey(256)&&BoardBuffer.retrieve()!=null){
			BoardBuffer.retrieve().placeOnBoard(this);
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
