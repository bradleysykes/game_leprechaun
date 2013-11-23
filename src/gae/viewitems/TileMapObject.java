package gae.viewitems;

import jgame.JGObject;

public class TileMapObject extends MapObject {
	private static final int TILE_COL_ID = 1;

	public TileMapObject(String name,double x, double y,String gfxname, BoardListViewItem viewItem) {
		super(name, x, y, gfxname, viewItem, TILE_COL_ID);
	}
	
	@Override
	public void hit(JGObject tile) {
		if (tile.colid==TILE_COL_ID) {
			tile.remove();
		}
	}
}
