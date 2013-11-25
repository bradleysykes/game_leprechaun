package data.encoder;

import java.util.Map;
import model.tile.Tile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ImageEncoder extends Encoder {

    Document myXmlDocument;
    Map<String, String> myTileImagesMap;
    Map<String, String> myUnitImagesMap;
    Element myRoot;
    
    public ImageEncoder(Document xmlDocument, Map<String, String> tileImagesMap, 
                        Map<String, String> unitImagesMap, Element root) {
        myXmlDocument = xmlDocument;
        myTileImagesMap = tileImagesMap;
        myUnitImagesMap = unitImagesMap;
        myRoot = root;
    }
    
    @Override
    protected void encode () {
        appendImages();
    }

    private void appendImages () {
        Element imageMapElement = myXmlDocument.createElement(IMAGE_MAP);
        appendTileImages(imageMapElement);
        appendUnitImages(imageMapElement);
        myRoot.appendChild(imageMapElement);
    }
    
    private void appendUnitImages(Element imageMapElement) {
        Element unitImages = myXmlDocument.createElement(UNIT_IMAGES);  
        appendSingleImage();
        imageMapElement.appendChild(unitImages);
    }
    
    private void appendTileImages(Element imageMapElement) {
        Element tileImages = myXmlDocument.createElement(TILE_IMAGES);
        appendSingleImage();
        imageMapElement.appendChild(tileImages);
    }
    
    private void appendSingleImage () {
        
    }
    
    
    
}
