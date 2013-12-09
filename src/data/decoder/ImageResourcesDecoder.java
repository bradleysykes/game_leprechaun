package data.decoder;

import java.util.HashMap;
import java.util.Map;
import model.tile.Tile;
import model.unit.Unit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Image Resource Decoder class is in charge of instantiating "Type" objects
 * and get the image resouece information used by the game authoring evironment
 * and the game player. 
 * 
 * @author Seunghyun Lee
 */

public class ImageResourcesDecoder extends Decoder {
    
    public ImageResourcesDecoder(DataManager manager) {
        super(manager);
    }
    
    private Map<Tile, String> createTileImageMap(Element root, String tag) {
        MapDecoder decoder = new MapDecoder(myDataManager);
        Map<Tile, String> imageMap = new HashMap<Tile, String>();
        Element images = (Element)root.getElementsByTagName(tag).item(0);
        NodeList imageList = images.getElementsByTagName(IMAGE);
        for(int i = 0; i < imageList.getLength(); i++) {
            Element image = (Element)imageList.item(i);
            String src = image.getAttribute(SRC);
            Tile tile = decoder.createTile((Element)image.getElementsByTagName("TileType").item(0), true);
            imageMap.put(tile, src);
        }
        return imageMap;
    }

    private Map<Unit, String> createUnitImageMap(Element root, String tag) {
        UnitDecoder decoder = new UnitDecoder(myDataManager);
        Map<Unit, String> imageMap = new HashMap<Unit, String>();
        Element images = (Element) root.getElementsByTagName(tag).item(0);
        NodeList imageList = images.getElementsByTagName(IMAGE);
        for(int i = 0; i < imageList.getLength(); i++) {
            Element image = (Element)imageList.item(i);
            String src = image.getAttribute(SRC);
            Unit unit = decoder.createUnitType((Element)image.getElementsByTagName("UnitType").item(0));
            imageMap.put(unit, src);
        }
        return imageMap;
    }
    
    @Override
    public void buildObject (Element root) {
        Element imageRoot = (Element)root.getElementsByTagName(IMAGE_MAP).item(0);
        myDataManager.setTileImageMap(createTileImageMap(imageRoot, TILE_IMAGES));
        myDataManager.setUnitImageMap(createUnitImageMap(imageRoot, UNIT_IMAGES));
    }
}


