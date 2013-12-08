package engine.listeners;

import engine.GameEngine;

public class ViewOffsetListener {
	
	private GameEngine myGameEngine;
	private int xOffset;
	private int yOffset;
	
	private static final int SCROLL_OFFSET = 40;
	
	public ViewOffsetListener(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		xOffset = 0; //gameEngine.pfWidth()/2;
		yOffset = 0; //gameEngine.pfHeight()/2;
	}
	
	public void setOffset(){
		this.checkOffsetKeys();
		myGameEngine.setViewOffset(xOffset, yOffset, false);
	}
	
	private void checkOffsetKeys() {
		if (myGameEngine.getKey(myGameEngine.KeyUp)) {
			myGameEngine.clearKey(myGameEngine.KeyUp);
			yOffset-=SCROLL_OFFSET;
			if (yOffset < 0) yOffset = 0;
		}
		if (myGameEngine.getKey(myGameEngine.KeyRight)) {
			myGameEngine.clearKey(myGameEngine.KeyRight);
			xOffset+=SCROLL_OFFSET;
			if (xOffset > myGameEngine.pfWidth() - myGameEngine.getSize().width) {
				xOffset = myGameEngine.pfWidth() - myGameEngine.getSize().width;
			}
		}
		if (myGameEngine.getKey(myGameEngine.KeyDown)) {
			myGameEngine.clearKey(myGameEngine.KeyDown);
			yOffset+=SCROLL_OFFSET;
			if (yOffset > myGameEngine.pfHeight() - myGameEngine.getSize().height) {
				yOffset = myGameEngine.pfHeight() - myGameEngine.getSize().height;
			}
		}
		if (myGameEngine.getKey(myGameEngine.KeyLeft)) {
			myGameEngine.clearKey(myGameEngine.KeyLeft);
			xOffset-=SCROLL_OFFSET;
			if (xOffset < 0) xOffset = 0;
		}	
	}
	
	public int getXOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}
	
}
