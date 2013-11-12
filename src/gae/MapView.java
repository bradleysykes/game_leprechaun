package gae;

import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class MapView extends JGEngine {

	public MapView(){
		initEngineComponent(500,500);
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(16, 16, 500, 500, JGColor.blue, JGColor.blue, null);
		
	}
	
	public void placeOnBoard(){
		if(this.getKey(256)&&BoardBuffer.retrieve()!=null){
			defineImage(BoardBuffer.retrieve().getName(),"-",0, "resources/"+BoardBuffer.retrieve().getRelativeImagePath(),"-");
			new JGObject("test", true, this.getMouseX(),this.getMouseY(), 0, BoardBuffer.retrieve().getName());
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

}
