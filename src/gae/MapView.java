package gae;

import util.reflection.Reflection;
import model.GameMap;
import model.tile.Tile;
import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class MapView extends JGEngine {

	public MapView(){
		initEngineComponent(500,500);
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, displayWidth(), displayHeight(), JGColor.blue, JGColor.blue, null);
	}
	
	public void placeOnBoard(){
//		if(this.getKey(256)&&BoardBuffer.retrieve()!=null){
//			defineImage(Bo,"-",0, "resources/"+BoardBuffer.retrieve().getRelativeImagePath(),"-");
//			new JGObject("test", true, this.getMouseX(),this.getMouseY(), 0, BoardBuffer.retrieve().getName());
//		}
	}
	
	public void doFrame(){
		placeOnBoard();
	}

	@Override
	public void initGame() {
		setFrameRate(40, 1);
		setPFSize(1,1);
	}


	public void setDefaultTiles(String className) {
		GameMap map = new GameMap(this.getWidth(),this.getHeight());
		for(int q=0;q<this.pfHeight();q+=20){
			for(int m = 0;m<this.pfWidth();m+=20){
				Reflection.createInstance(className);
			}
		}
	}

}
