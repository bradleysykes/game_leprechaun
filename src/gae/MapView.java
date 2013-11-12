package gae;

import com.sun.prism.paint.Color;

import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class MapView extends JGEngine {

	public MapView(){
		initEngineComponent(500,500);
		this.addMouseListener(new MapMouseListener(this));
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, displayWidth(), displayHeight(), JGColor.blue, JGColor.blue, null);
	}
	
	public void placeOnBoard(){
		if(this.getKey(256)&&BoardBuffer.retrieve()!=null){
			defineImage(BoardBuffer.retrieve().getName(),"-",0, "resources/"+BoardBuffer.retrieve().getRelativeImagePath(),"-");
			new JGObject("test", true, this.getMouseX(),this.getMouseY(), 0, BoardBuffer.retrieve().getName()).snapToGrid();
		}
	}
	
	public void doFrame(){
		placeOnBoard();
	}

	@Override
	public void initGame() {
		setFrameRate(40, 1);
		setPFSize(16,16);
	}

}
