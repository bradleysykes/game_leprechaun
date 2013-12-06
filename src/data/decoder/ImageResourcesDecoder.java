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
    
    private Map<String, String> getImageMap(Element root, String tag) {
        Map<String, String> imageMap = new HashMap<String, String>();
        Element images = (Element)root.getElementsByTagName(tag).item(0);
        NodeList imageList = images.getElementsByTagName(IMAGE);
        for(int i = 0; i < imageList.getLength(); i++) {
            Element image = (Element)imageList.item(i);
            String id = image.getAttribute(ID);
            String src = image.getAttribute(SRC);
            imageMap.put(id, src);
        }
        return imageMap;
    }

    private Map<Tile, String> convertTileImageMap (Map<String, String> map) {
        Map<Tile, String> imageMap = new HashMap<Tile, String>();
        for(String id : map.keySet()) {
            Tile key = myDataManager.getTile(id);
            imageMap.put(key, map.get(id));
        }
        return imageMap;
    }
    
    private Map<Unit, String> convertUnitImageMap (Map<String, String> map) {
        Map<Unit, String> imageMap = new HashMap<Unit, String>();
        for (String id : map.keySet()) {
           Unit key = myDataManager.getUnit(id);
           imageMap.put(key, map.get(id));
        }
        return null;
    }
    
    @Override
    public void decodeData (Element root) {
        Element imageRoot = (Element)root.getElementsByTagName(IMAGE_MAP).item(0);
        myDataManager.setTileImageMap(convertTileImageMap(getImageMap(imageRoot, TILE_IMAGES)));
        myDataManager.setUnitImageMap(convertUnitImageMap(getImageMap(imageRoot, UNIT_IMAGES)));
    }
}


