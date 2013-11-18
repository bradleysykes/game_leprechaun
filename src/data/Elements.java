package data;

/**
 * Interface of constants used for element names in the XML file
 * @author Alex Song, Seunghyun Lee
 *
 */
public interface Elements {
    // for MapEncoder and MapDecoder
    String MAP_ROOT = "map";
    String TILE = "tile";
    String TERRAIN = "terrain";
    String RESOURCES = "resources";
    String RESOURCE = "resource";
    
    // for UnitEncoder and UnitDecoder
    String UNIT_ROOT = "units";
    String UNIT = "unit";
    String ATTRIBUTES = "Attributes";
    
    //for PlayerDecoder
}
