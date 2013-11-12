package gae;

import com.sun.prism.paint.Color;

import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class MapView extends JGEngine {

	public MapView(){
		initEngineComponent(500,500);
	}
	
	
	@Override
	public void initCanvas() {
<<<<<<< HEAD
		setCanvasSettings(1, 1, displayWidth(), displayHeight(), JGColor.blue, JGColor.blue, null);
=======
		setCanvasSettings(16, 16, 500, 500, JGColor.blue, JGColor.blue, null);
		
>>>>>>> 5d573bfc7588d22ba48f1939e03c493348557eff
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
