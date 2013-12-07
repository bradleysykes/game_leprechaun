package data.decoder;

import java.util.HashMap;
import java.util.Map;
import model.Player;
import model.tile.Tile;
import model.unit.Unit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ImageResourcesDecoder extends Decoder {
    
    private DataManager myDataManager;
    
    public ImageResourcesDecoder(DataManager manager) {
        myDataManager = manager;
    }
    
    private Map<Tile, String> getTileImageMap(Element root, String tag) {
        MapDecoder decoder = new MapDecoder(myDataManager);
        Map<Tile, String> imageMap = new HashMap<Tile, String>();
        Element images = (Element)root.getElementsByTagName(tag).item(0);
        NodeList imageList = images.getElementsByTagName(IMAGE);
        for(int i = 0; i < imageList.getLength(); i++) {
            Element image = (Element)imageList.item(i);
            String src = image.getAttribute(SRC);
            Tile tile = decoder.processTile((Element)image.getElementsByTagName("TileType").item(0), true);
            imageMap.put(tile, src);
        }
        return imageMap;
    }

    private Map<Unit, String> getUnitImageMap(Element root, String tag) {
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
    public void decodeData (Element root) {
        Element imageRoot = (Element)root.getElementsByTagName(IMAGE_MAP).item(0);
        myDataManager.setTileImageMap(getTileImageMap(imageRoot, TILE_IMAGES));
        myDataManager.setUnitImageMap(getUnitImageMap(imageRoot, UNIT_IMAGES));
    }
}


