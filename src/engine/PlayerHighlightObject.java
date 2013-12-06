package engine;

import model.tile.Tile;

public class PlayerHighlightObject extends HighlightObject {
	
	public PlayerHighlightObject(Tile tile, GameEngine gameEngine) {
		super(EngineConstants.PlayerHighlightName, EngineConstants.PlayerHighlight_COL_ID, tile, gameEngine, EngineConstants.PlayerHighlightColor);
	}
	
}
