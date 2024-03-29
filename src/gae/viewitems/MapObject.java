package gae.viewitems;

import gae.Constants;

import java.awt.Point;

import jgame.JGObject;


/**
 * Class used to visually display a BoardListViewItem on the map. Extends JGObject.
 * @author Bradley Sykes and William Shelburne
 *
 */
public class MapObject extends JGObject implements Constants {
	
	private BoardListViewItem myViewItem;
	private Point myPoint;
	
	public MapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem) {
		this(name, x, y, gfxname, viewItem, 0);
	}
	
	protected MapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem, int Colid) {
		super(name, true, x, y, Colid, gfxname);
		int modelX = (int)x/TILE_SIZE;
		int modelY = (int)y/TILE_SIZE;
		myPoint = new Point(modelX,modelY);
		myViewItem = viewItem;
	}

	public Point getPoint() {
		return myPoint;
	}

	public void select() {
		// do nothing for now.
	}
}
