package gae.viewitems;

import jgame.JGObject;

public class MapObject extends JGObject {
	
	private BoardListViewItem myViewItem;
	public MapObject(double x, double y,String gfxname, BoardListViewItem viewItem) {
		super("mapObject", true, x, y, 0, gfxname);
		myViewItem = viewItem;
	}

}
