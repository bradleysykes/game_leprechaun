package engine;

import jgame.JGColor;

public interface EngineConstants {
	
	final int MOUSE_COL_ID = 1;
	final int TileHighlight_COL_ID = 4;
	final int PlayerHighlight_COL_ID = 16;
	final int SelectionHighlight_COL_ID = 32;
	final int myViewerWidth = 640;
	final int myViewerHeight = 480;
	final int myTileWidth = 79;
	final int myTileHeight = 79;
	final String TileHighlightName = "zhighlight";
	final JGColor TileHighlightColor = JGColor.cyan;
	final String PlayerHighlightName = "zzhighlight";
	final JGColor PlayerHighlightColor = JGColor.red;
	final String SelectionHighlightName = "zzzhighlight";
	final JGColor SelectionHighlightColor = JGColor.red;
	final String endScreenName = "endscreen";
	final String endScreenPath = "\\testimages\\swordandshield.jpg";
	
}

