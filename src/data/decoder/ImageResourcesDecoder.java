package data.decoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        NodeList imageList = images.getElementsByTagName(IMAGE_TAG);
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
        myDataManager.setTileImageMap(getImageMap(root, TILE_IMAGES));
        myDataManager.setUnitImageMap(getImageMap(root, UNIT_IMAGES));
    }

}


