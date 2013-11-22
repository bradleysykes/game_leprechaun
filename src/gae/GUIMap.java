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

public class GUIMap extends JGEngine {
	
	private MapEncoder myEncoder;
	private int myWidth;
	private int myHeight;
	private GameMap myMap;

	public GUIMap(int width, int height, int componentWidth, int componentHeight){
		myWidth = width;
		myHeight = height;
		initEngineComponent(componentWidth,componentHeight);
		//myMap = new GameMap(width,height);
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, myWidth, myHeight, null,null, null);
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
		setPFSize(myWidth,myHeight);
	}


	public void fillBoard(ViewItem tile) {
		TileViewItem t = (TileViewItem)tile;
		int x = 0;
		for(int q=0;q<myWidth;q+=1){
			for(int m = 0;m<myHeight;m+=1){
				if(x==100){
					return;
				}
				System.out.println("Tile placed");
				t.placeOnBoard(this, q, m);
				x++;
			}
		}
	}

}
