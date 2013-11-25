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
    String ABILITIES = "Abilities";
    String UNIT_TILE = "UnitTile";
    String UNIT_PLAYER = "UnitPlayer";
    
    //for PlayerDecoder
    String PLAYERS = "Players";
    String PLAYER = "Player";
    
    //for ConditionEncoder
    String CONDITIONS = "Conditions";
    String CONDITION = "Condition";
    String CONDITION_UNIT = "ConditionUnit";
    String CONDITION_TILE = "ConditionTile";

    //for ImageResourceDecoder
    String IMAGE_MAP = "ImageMap";
    String IMAGE_TAG = "Image";
    String TILE_IMAGES = "tileImages";
    String UNIT_IMAGES = "unitImages";
}
