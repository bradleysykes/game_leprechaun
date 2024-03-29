package engine;

import java.util.List;

import engine.gui.UnitListArea;
import engine.listeners.ViewOffsetListener;
import model.Ability;
import model.Model;
import model.tile.Tile;
import model.unit.Unit;
import jgame.JGObject;
import jgame.JGTimer;

public class MouseObject extends JGObject implements EngineConstants{
	
	private GameEngine myGameEngine;
	private ViewOffsetListener myViewListener;
	//private boolean myClickDelay = false;
	
	public MouseObject(GameEngine gameEngine, ViewOffsetListener viewListener) {
		super("mouse", false, gameEngine.getMouseX(), gameEngine.getMouseY(), MOUSE_COL_ID, null);
		myViewListener = viewListener;
		this.setBBox((int)x,(int)y,1,1);
		myGameEngine = gameEngine;
		
	}
	
	public void move() {
		x = myGameEngine.getMouseX() + myViewListener.getXOffset();
		y = myGameEngine.getMouseY() + myViewListener.getYOffset();
		
		// Helps prevent unintentional double-clicks
//		if(myGameEngine.getMouseButton(1) && !myClickDelay){
//			this.colid = MOUSE_COL_ID;
//			myClickDelay = true;
//			new JGTimer(10, true){
//				public void alarm() {
//					myClickDelay = false;
//				}
//			};
//		}
//		else{
//			this.colid = 0;	
//		}
	}
	
//	public void hit(JGObject other) {
//		if (myGameEngine.getMouseButton(1)) {
//			myGameEngine.clearMouseButton(1);
//			
//		}
//	}
	
}
