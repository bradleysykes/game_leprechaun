package gae.viewitems;

import jgame.JGObject;

public class MapObject extends JGObject {
	
	private BoardListViewItem myViewItem;
	public MapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem) {
		super(name, true, x, y, 0, gfxname);
		myViewItem = viewItem;
	}

}
