package engine.listeners;

import engine.GameEngine;

public class ViewOffsetListener {
	
	private GameEngine myGameEngine;
	private int xOffset;
	private int yOffset;
	
	private static final int SCROLL_OFFSET = 40;
	
	public ViewOffsetListener(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		xOffset =  myGameEngine.getMouseX()*gameEngine.pfWidth()/2;
		yOffset = myGameEngine.getMouseY()*gameEngine.pfHeight()/2;
	}
	
	public void setOffset(){
		this.checkOffsetKeys();
		myGameEngine.setViewOffset(xOffset, yOffset, true);
	}
	
	private void checkOffsetKeys() {
		if (myGameEngine.getKey(myGameEngine.KeyUp)) {
			myGameEngine.clearKey(myGameEngine.KeyUp);
			yOffset-=SCROLL_OFFSET;
		}
		if (myGameEngine.getKey(myGameEngine.KeyRight)) {
			myGameEngine.clearKey(myGameEngine.KeyRight);
			xOffset+=SCROLL_OFFSET;
		}
		if (myGameEngine.getKey(myGameEngine.KeyDown)) {
			myGameEngine.clearKey(myGameEngine.KeyDown);
			yOffset+=SCROLL_OFFSET;
		}
		if (myGameEngine.getKey(myGameEngine.KeyLeft)) {
			myGameEngine.clearKey(myGameEngine.KeyLeft);
			xOffset-=SCROLL_OFFSET;
		}	
	}
	
}
