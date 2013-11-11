package gae;

import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class MapView extends JGEngine {

	public MapView(){
		initEngineComponent(300,300);
	}
	
	
	@Override
	public void initCanvas() {
		setCanvasSettings(1, 1, displayWidth(), displayHeight(), null, JGColor.white, null);
	}
	
	public void placeOnBoard(BoardListItem item){
		System.out.println(this.getMouseX());
		new JGObject("test", true, this.getMouseX(),this.getMouseY(), 0, "test");
	}

	@Override
	public void initGame() {
		setFrameRate(40, 1);
		setPFSize(300, 300);
		defineImage("test","-",0,"../gae_resources/test_icon_image.png","-");
		new JGObject("test", true, viewWidth()/2,viewHeight()/2, 0, "test");
	}

}
