package engine.listeners;

import engine.GameEngine;

public class ViewOffsetListener {
	
	private GameEngine myGameEngine;
	private int xOffset;
	private int yOffset;
	
	public ViewOffsetListener(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		xOffset = gameEngine.pfWidth()/2;
		yOffset = gameEngine.pfHeight()/2;
	}
	
	public void setOffset(){
		this.checkOffsetKeys();
		myGameEngine.setViewOffset(xOffset, yOffset, true);
	}
	
	private void checkOffsetKeys() {
		if (myGameEngine.getKey(myGameEngine.KeyUp)) {
			myGameEngine.clearKey(myGameEngine.KeyUp);
			yOffset--;
		}
		if (myGameEngine.getKey(myGameEngine.KeyRight)) {
			myGameEngine.clearKey(myGameEngine.KeyRight);
			xOffset++;
		}
		if (myGameEngine.getKey(myGameEngine.KeyDown)) {
			myGameEngine.clearKey(myGameEngine.KeyDown);
			yOffset++;
		}
		if (myGameEngine.getKey(myGameEngine.KeyLeft)) {
			myGameEngine.clearKey(myGameEngine.KeyLeft);
			xOffset--;
		}
	}
	
}
