package data_encoder;

/**
 * Interface of constants used for element names in the XML file
 * @author Alex Song
 *
 */
public interface Elements {
    // for MapEncoder
    String MAP_ROOT_NAME = "map";
    String TILE = "tile";
    String TERRAIN = "terrain";
    String RESOURCES = "resources";
    String RESOURCE = "resource";
    // for UnitEncoder
    String UNIT_ROOT_NAME = "unit";
}
