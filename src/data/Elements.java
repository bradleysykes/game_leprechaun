package data;

/**
 * Interface of constants used for element names in the XML file
 * @author Alex Song, Seunghyun Lee
 *
 */
public interface Elements {
    String GAME_ELEMENTS = "GameElements";
    // for MapEncoder and MapDecoder
    String MAP = "Map";
    String TILE = "Tile";
    String STAT = "Stat";
    String TERRAIN = "Terrain";
    String RESOURCES = "Resources";
    String RESOURCE = "Resource";
    
    // for UnitEncoder and UnitDecoder
    String UNITS = "Units";
    String UNIT = "Unit";
    String ATTRIBUTES = "Attributes";
    String ABILITITES = "Abilities";
    String UNIT_PLAYER = "UnitPlayer";
    String UNIT_TILE = "UnitTile";
    
    //for PlayerDecoder
    String PLAYERS = "Players";
    String PLAYER = "Player";

}
