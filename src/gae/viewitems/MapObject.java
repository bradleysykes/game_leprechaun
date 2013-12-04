package gae.viewitems;

import java.awt.Point;

import jgame.JGObject;

public class MapObject extends JGObject {
	
	private BoardListViewItem myViewItem;
	private Point myPoint;
	
	public MapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem) {
		this(name, x, y, gfxname, viewItem, 0);
	}
	
	protected MapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem, int Colid) {
		super(name, true, x, y, Colid, gfxname);
		myPoint = new Point((int)x,(int)y);
		myViewItem = viewItem;
	}

	public Point getPoint() {
		return myPoint;
	}

	public void select() {
		System.out.println("I AM SELECTED");
	}
}
