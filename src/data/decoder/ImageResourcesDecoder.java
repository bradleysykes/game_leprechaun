package data.decoder;

import java.util.HashMap;
import java.util.Map;
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
            Element image = (Element)imageList.item(0);
            String id = image.getAttribute(ID);
            String src = image.getAttribute(SRC);
            imageMap.put(id, src);
        }
        return imageMap;
    }

    @Override
    public void decodeData (Element root) {
        Element imageRoot = (Element)root.getElementsByTagName(IMAGE_MAP).item(0);
        myDataManager.setTileImageMap(getImageMap(imageRoot, TILE_IMAGES));
        myDataManager.setUnitImageMap(getImageMap(imageRoot, UNIT_IMAGES));
    }
}


