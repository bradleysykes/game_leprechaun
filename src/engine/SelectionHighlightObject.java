package engine;

import model.tile.Tile;

public class SelectionHighlightObject extends HighlightObject {

	public SelectionHighlightObject(Tile tile, GameEngine gameEngine) {
		super(EngineConstants.SelectionHighlightName, EngineConstants.SelectionHighlight_COL_ID, tile, gameEngine, EngineConstants.SelectionHighlightColor);
	}
	
}
