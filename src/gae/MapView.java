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
	
	public void placeOnBoard(BoardListItem item){
		if(this.getKey(256)){
			defineImage("test","-",0,"../gae_resources/test_icon_image.png","-");
			new JGObject("test", true, this.getMouseX(),this.getMouseY(), 0, "test");
			System.out.println(this.countObjects("test", 0));
		}
	}
	
	public void doFrame(){
		if(this.getKey(256)&&BoardBuffer.retrieve()!=null){
			defineImage("test","-",0,"../gae_resources/test_icon_image.png","-");
			new JGObject("test", true, this.getMouseX(),this.getMouseY(), 0, "test");
			System.out.println(this.countObjects("test", 0));
		}
	}

	@Override
	public void initGame() {
		setFrameRate(40, 1);
		setPFSize(this.viewWidth(), this.viewHeight());
		defineImage("test","-",0,"../gae_resources/test_icon_image.png","-");
		new JGObject("test", true, viewWidth()/2,viewHeight()/2, 0, "test");
	}

}
