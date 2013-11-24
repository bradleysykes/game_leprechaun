package data;

/**
 * Interface of constants used for element names in the XML file
 * @author Alex Song, Seunghyun Lee
 *
 */
public interface Elements {
    String GAME_ELEMENTS = "GameElements";
    // for MapEncoder and MapDecoder
    String MAP_ROOT = "Map";
    String TILE = "Tile";
    String STAT = "Stat";
    String TERRAIN = "Terrain";
    String RESOURCES = "Resources";
    String RESOURCE = "Resource";
    
    // for UnitEncoder and UnitDecoder
    String UNIT_ROOT = "Units";
    String UNIT = "Unit";
    String ATTRIBUTES = "Attributes";
    String PLAYERS = "Players";
    
    //for PlayerDecoder
    String PLAYER_ROOT = "Players";
    String PLAYER = "Player";
    
    String TERRAIN_TAG= "Terrain";
    String RESOURCES_TAG = "Resources";

}
