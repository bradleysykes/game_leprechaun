package gae.viewitems;

import jgame.JGObject;

public class MapObject extends JGObject {
	
	private BoardListViewItem myViewItem;
	public MapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem) {
		this(name, x, y, gfxname, viewItem, 0);
	}
	
	protected MapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem, int Colid) {
		super(name, true, x, y, Colid, gfxname);
		myViewItem = viewItem;
	}
}
